package com.acmspring.co.openweatherapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Summary {
    private String fecha;
    private double tempPromedio;
    private String descripcionGeneral;
    private double tempMin;
    private double tempMax;
}
