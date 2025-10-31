package com.acmspring.co.openweatherapi.services;
import com.acmspring.co.openweatherapi.models.Summary;
import com.acmspring.co.openweatherapi.models.WeatherForecast;
import com.acmspring.co.openweatherapi.models.ForecastResponse;
import com.acmspring.co.openweatherapi.models.ForecastSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class ForecastService {

    private final WebClient webClient;

    @Value("${openweather.api.key}")
    private String apiKey;

    @Autowired
    public ForecastService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ForecastResponse> getForecastByCity(String city) {
        return webClient.get().uri(uriBuilder -> uriBuilder.
                path("/forecast")
                .queryParam("q", city)
                .queryParam("units", "metric")
                .queryParam("lang", "es")
                .queryParam("appid", apiKey)
                .build())
                .retrieve()
                .bodyToMono(ForecastResponse.class);
    }

    public Mono<ForecastSummary> getForecastSummaryByCity(String city) {
        return getForecastByCity(city)
                .map(this::makeSummary);
    }
    private ForecastSummary makeSummary(ForecastResponse response) {
        Summary summary24h = calculate24h(response.getList());
        List<Summary> summary3d = calculate3d(response.getList());
        return new ForecastSummary(summary24h, summary3d);
    }

    private Summary calculate24h(List<WeatherForecast> forecasts) {
        List<Summary> day1 = List.of(calculateDailySummary(forecasts));
        return day1.get(0);
    }

    private List<Summary> calculate3d(List<WeatherForecast> forecasts) {
        List<WeatherForecast> day1 = forecasts.subList(0, 7);
        List<WeatherForecast> day2 = forecasts.subList(7, 14);
        List<WeatherForecast> day3 = forecasts.subList(14, 21);

        return List.of(calculateDailySummary(day1), calculateDailySummary(day2), calculateDailySummary(day3));
    }

    private Summary calculateDailySummary(List<WeatherForecast> forecasts) {
        double tempPromedio = 0;
        for (WeatherForecast f : forecasts) {
            tempPromedio += f.getMain().getTemp();
        }
        tempPromedio /= forecasts.size();

        // Temp mínima
        double tempMin = forecasts.get(0).getMain().getTempMin();
        for (WeatherForecast f : forecasts) {
            if (f.getMain().getTempMin() < tempMin) {
                tempMin = f.getMain().getTempMin();
            }
        }

        // Temp máxima
        double tempMax = forecasts.get(0).getMain().getTempMax();
        for (WeatherForecast f : forecasts) {
            if (f.getMain().getTempMax() > tempMax) {
                tempMax = f.getMain().getTempMax();
            }
        }
        String fechaCompleta = forecasts.get(0).getDate();
        String fecha = fechaCompleta.substring(0, 10);
        String descripcionGeneral = forecasts.get(0).getWeather().get(0).getDescription();

        return new Summary(fecha, tempPromedio, descripcionGeneral, tempMin, tempMax);
    }


}
