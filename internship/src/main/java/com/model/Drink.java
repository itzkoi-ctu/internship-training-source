package com.model;

import java.time.LocalDate;

import com.enums.ProductCategory;
import com.enums.ProductStatus;

public class Drink extends Product{
	private boolean hasIce;

	public Drink(int id, String name, double price, LocalDate cratedAt, int stockQuantity ,boolean hasIce) {
		super(id, name, price,ProductStatus.AVAILABLE, cratedAt, stockQuantity);
		this.hasIce = hasIce;
	}

	@Override
	public ProductCategory getCategory() {
		return ProductCategory.DRINK;
	}

	@Override
	public double calculateFinalPrice() {
		
		return getPrice();
	}

	@Override
	public String toString() {
		return "Drink [Id: " +getId()+", " + "name=" + getName() + ", price=" + getPrice()+", status = "+getStatus()+", stock quantity = "+ getStockQuantity()
				+", ice = "+hasIce+ ", created at=" + getCratedAt() + "]";
	}

	@Override
	public boolean isAvailable() {
		return getStockQuantity() >= 1 && getStatus() != ProductStatus.OUT_OF_STOCK;
	}
	
	
	
	

}
