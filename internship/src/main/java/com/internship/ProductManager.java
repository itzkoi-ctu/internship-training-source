package com.internship;

import java.util.ArrayList;
import java.util.List;

import com.enums.ProductCategory;
import com.enums.ProductStatus;
import com.model.Product;

public class ProductManager implements Managable<Product> {
	List<Product> products = new ArrayList<Product>();

	@Override
	public void add(Product item) {
		validateProduct(item);
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == item.getId()) {
				throw new IllegalArgumentException("Product " + item.getId() + " is already exist.");

			}

		}
		this.products.add(item);
		System.out.println("Add new product successfully.");
	}

	@Override
	public void deleteById(int id) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id) {
				products.remove(i);

			}

		}
		System.out.println("Product is deleted.");

	}

	@Override
	public Product findById(int id) {
		for (Product product : products) {
			if (product.getId() == id) {
				return product;
			}
		}
		throw new IllegalArgumentException("Product not found with id: " + id);
	}

	@Override
	public List<Product> findAll() {
		return products;
	}

	protected void displayAllProduct() {

		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
	}

	protected void displayAllProduct(List<Product> products) {
		if (products == null || products.isEmpty()) {
	        System.out.println("Hiện tại không có sản phẩm nào trong hệ thống để sắp xếp!");
		}
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
	}

	protected Product findByName(String name) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(name)) {
				return products.get(i);
			}
		}
		throw new IllegalArgumentException("Product not found with id: " + name);

	}

	protected List<Product> filterByCategory(ProductCategory category) {
		List<Product> filteredProducts = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCategory() == category) {
				filteredProducts.add(products.get(i));
			}
		}
		return filteredProducts;

	}

	protected List<Product> filterProductAvailable() {
		List<Product> filteredProducts = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getStatus() == ProductStatus.AVAILABLE) {
				filteredProducts.add(products.get(i));
			}
		}
		return filteredProducts;

	}

	protected List<Product> sortByPriceAscending() {
		// clone list
		List<Product> sortedList = new ArrayList<Product>();
		for (Product product : products) {
			sortedList.add(product);
		}

		// loop each element
		for (int i = 0; i < sortedList.size(); i++) {
			// index is i
			int minIndex = i;

			// loop from i+1
			for (int j = i + 1; j < sortedList.size(); j++) {
				// if the price of next element greater than price of minIndex swap it
				if (sortedList.get(j).getPrice() < sortedList.get(minIndex).getPrice()) {
					minIndex = j;
				}

			}

			Product temp = sortedList.get(i);
			sortedList.set(i, sortedList.get(minIndex));
			sortedList.set(minIndex, temp);
		}
		return sortedList;

	}

	protected List<Product> sortByPriceDecreasing() {
		List<Product> sortedProduct = new ArrayList<>();
		for (Product product : products) {
			sortedProduct.add(product);
		}

		for (int i = 0; i < sortedProduct.size(); i++) {
			int minIndex = i;

			for (int j = i + 1; j < sortedProduct.size(); j++) {
				if (sortedProduct.get(j).getPrice() > sortedProduct.get(minIndex).getPrice()) {
					minIndex = j;
				}
			}
			Product temp = sortedProduct.get(i);
			sortedProduct.set(i, sortedProduct.get(minIndex));
			sortedProduct.set(minIndex, temp);
		}
		return sortedProduct;
	}

	protected Product findHighestPrice() {
		Product highestPriceProduct = products.get(0);
		double highestPrice = highestPriceProduct.getPrice();
		for (int i = 1; i < products.size(); i++) {
			if (products.get(i).getPrice() > highestPrice) {
				highestPriceProduct = products.get(i);
				highestPrice = products.get(i).getPrice();
			}
		}
		return highestPriceProduct;
	}
	protected double calculateAvgPrice() {
		double avgPrice = 0;
		for(int i = 0; i < products.size() ; i++) {
			avgPrice+= products.get(i).getPrice();
		}
		return avgPrice/products.size();
	}

	private void validateProduct(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Product is null, cannot add new product.");

		}
		if (product.getName().isEmpty() || product.getPrice() <= 0) {
			throw new IllegalArgumentException("Invalid product");

		}
		

	}

	@Override
	public void update(Product item) {
		validateProduct(item);
		for(int i = 0 ; i < products.size() ; i++) {
			if(products.get(i).getId() == item.getId()) {
				products.set(i, item);
			}
		}
		System.out.println("Update product successfully.");
		
	}

}
