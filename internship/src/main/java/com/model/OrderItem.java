package com.model;

public class OrderItem {
	Product product;
	int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		if(product == null) {
			throw new IllegalArgumentException("Product in order must not be null.");
		}
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity <=0) {
			throw new IllegalArgumentException("Quantity in order must be greater than 0.");
		}
		this.quantity = quantity;
	}

	public OrderItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public double calculateSubTotal() {
		return product.calculateFinalPrice() * quantity;
	}
	
}
