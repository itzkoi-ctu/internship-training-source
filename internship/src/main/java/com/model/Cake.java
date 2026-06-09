package com.model;

import java.time.LocalDate;

import com.enums.ProductCategory;
import com.enums.ProductStatus;

public class Cake extends Product {

	private LocalDate expiredDate;

	public Cake(int id, String name, double price, LocalDate cratedAt, int stockQuantity, LocalDate expiredDate) {
		super(id, name, price,ProductStatus.AVAILABLE, cratedAt, stockQuantity);
		this.expiredDate = expiredDate;
	}

	@Override
	public ProductCategory getCategory() {
		return ProductCategory.CAKE;
	}

	@Override
	public double calculateFinalPrice() {
		if (expiredDate.equals(LocalDate.now())) {
			return getPrice() * 0.8;
		}
		return getPrice();
	}

	@Override
	public String toString() {
		return "Cake [Id: " + getId() + ", name = " + getName() + ", price = " + getPrice() +", status: "+getStatus()+", stock quantity = "+getStockQuantity()+", created at = "+getCratedAt()+ ", expired date = "
				+ this.expiredDate + ", available = " + isAvailable() + "]";
	}

	@Override
	public boolean isAvailable() {
		if (getStockQuantity() < 1 || 
		        getStatus() == ProductStatus.OUT_OF_STOCK || 
		        expiredDate.isBefore(LocalDate.now())) {
		        return false;
		    }
		return true;
	}
	

}
