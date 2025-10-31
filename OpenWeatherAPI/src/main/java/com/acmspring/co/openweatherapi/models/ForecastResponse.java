package com.acmspring.co.openweatherapi.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ForecastResponse {
    private List<WeatherForecast> list;
}
