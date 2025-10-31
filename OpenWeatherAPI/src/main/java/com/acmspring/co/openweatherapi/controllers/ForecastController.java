package com.acmspring.co.openweatherapi.controllers;

import com.acmspring.co.openweatherapi.models.ForecastSummary;
import com.acmspring.co.openweatherapi.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/forecast5")
public class ForecastController {
    private final ForecastService forecastService;

    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping
    public Mono<ForecastSummary> getForecastByCity(@RequestParam String city) {
        return forecastService.getForecastSummaryByCity(city);
    }
    
}
