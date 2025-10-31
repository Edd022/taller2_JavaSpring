package com.acmspring.co.openweatherapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigWebClient {
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("api.openweathermap.org/data/2.5/")
                .build();

    }
}
