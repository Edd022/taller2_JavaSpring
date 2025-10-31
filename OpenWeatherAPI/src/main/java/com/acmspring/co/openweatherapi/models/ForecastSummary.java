package com.acmspring.co.openweatherapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ForecastSummary {

    //Resumen para 24 horas
    private Summary summary24h;

    //Resumen para 3 días
    private List<Summary> summary3d;

}
