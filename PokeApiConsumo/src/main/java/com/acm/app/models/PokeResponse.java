package com.acm.app.models;

import java.util.List;

public class PokeResponse {
	private int id;
	private String name;
	private int height;
	private int weight;
	private List<AbilityWrapper>	abilities;// se usa abiity wrapper pq hay una clase intermedia q tiene q actuar pq las habilidades individuales contienen otras caracteristicas
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public List<AbilityWrapper> getAbilities() {
		return abilities;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public PokeResponse() {
	}
	public PokeResponse(int id, String name, int height, int weight, List<AbilityWrapper> abilities) {
		this.id = id;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.abilities = abilities;
	}
	public void setAbilities(List<AbilityWrapper> abilities) {
		this.abilities = abilities;
	}
	
}
