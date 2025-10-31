package com.acmspring.co.openweatherapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WeatherForecast {
    @JsonProperty("dt_txt")
    private String date;
    private Main main;
    private List<Weather> weather;
    private double pop;
}
