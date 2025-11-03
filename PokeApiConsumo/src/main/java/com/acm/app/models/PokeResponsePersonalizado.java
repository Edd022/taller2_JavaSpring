package com.acm.app.models;

import java.util.List;

public class PokeResponsePersonalizado {
	 private String name;
	    private int weight;
	    private List<String> abilities;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public List<String> getAbilities() {
			return abilities;
		}
		public void setAbilities(List<String> abilities) {
			this.abilities = abilities;
		}
		public PokeResponsePersonalizado(String name, int weight, List<String> abilities) {
			this.name = name;
			this.weight = weight;
			this.abilities = abilities;
		}
	    
}
