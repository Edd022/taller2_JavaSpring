package com.acm.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.acm.app.models.PokeResponse;

import reactor.core.publisher.Mono;

@Service
public class PokeService {
	private final WebClient webClient;
	public PokeService(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public Mono<PokeResponse> getPokeByName(String name){
		return webClient.get()
				.uri("/pokemon/{name}", name.toLowerCase())
				.retrieve()
				.bodyToMono(PokeResponse.class);
	}
	
	
}
