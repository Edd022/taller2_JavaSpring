package com.acm.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.app.models.PokeResponse;
import com.acm.app.service.PokeService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pokemon")
public class PokeController {
	PokeService pokeService;
	
	public PokeController(PokeService pokeService) {
		this.pokeService = pokeService;
	}
	@GetMapping("/{name}")

	public Mono<PokeResponse> getPokemon(@PathVariable String name){
		return pokeService.getPokeByName(name);
	}
	
}
