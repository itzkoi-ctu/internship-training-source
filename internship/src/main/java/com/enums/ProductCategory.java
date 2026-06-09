package com.enums;

public enum ProductCategory {
	DRINK("Drink"), CAKE("Cake");
	
	String name;
	private ProductCategory(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	

}
