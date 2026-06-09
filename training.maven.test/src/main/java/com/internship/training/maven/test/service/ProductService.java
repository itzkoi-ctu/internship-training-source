package com.internship.training.maven.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.internship.training.maven.test.dto.request.CreateProductRequest;
import com.internship.training.maven.test.dto.request.UpdateProductRequest;
import com.internship.training.maven.test.dto.response.ProductResponse;
import com.internship.training.maven.test.model.Product;
import com.internship.training.maven.test.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductResponse createProduct(CreateProductRequest request) {
		validateCreateProductRequest(request);
		Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setStock(request.getStock());
		product.setCategory(request.getCategory());
		productRepository.save(product);

		return toProductResponse(product);
	}

	@Override
	public List<ProductResponse> getAllProducts() {
		List<ProductResponse> responses = new ArrayList<>();
		for (Product product : productRepository.findAll()) {
			responses.add(toProductResponse(product));
		}
		return responses;
	}

	@Override
	public ProductResponse getProductById(int id) {
		Product product = productRepository.findById(id);
		return toProductResponse(product);
	}

	@Override
	public ProductResponse updateProduct(int id, UpdateProductRequest request) {
		validateUpdateProductRequest(request);
		Product product = productRepository.findById(id);
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setStock(request.getStock());
		product.setCategory(request.getCategory());
		
		return toProductResponse(product);
	}

	@Override
	public void deleteProduct(int id) {
		Product product = productRepository.findById(id);
		
		productRepository.delete(product);
		

	}

	@Override
	public List<ProductResponse> getAvailableProducts() {
		List<ProductResponse> response = new ArrayList<>();
		for(Product product : productRepository.findAll()) {
			if(product.isAvailable()) {
				response.add(toProductResponse(product));
			}
		}
		return response;
	}

	private void validateCreateProductRequest(CreateProductRequest request) {
		if (request == null) {
			throw new IllegalArgumentException("Product request cannot be null");
		}

		if (request.getName() == null || request.getName().isBlank()) {
			throw new IllegalArgumentException("Product name cannot be empty");
		}

		if (request.getPrice() < 0) {
			throw new IllegalArgumentException("Product price cannot be negative");
		}

		if (request.getStock() < 0) {
			throw new IllegalArgumentException("Product stock cannot be negative");
		}
	}

	private void validateUpdateProductRequest(UpdateProductRequest request) {
		if (request == null) {
			throw new IllegalArgumentException("Product request cannot be null");
		}

		if (request.getName() == null || request.getName().isBlank()) {
			throw new IllegalArgumentException("Product name cannot be empty");
		}

		if (request.getPrice() < 0) {
			throw new IllegalArgumentException("Product price cannot be negative");
		}

		if (request.getStock() < 0) {
			throw new IllegalArgumentException("Product stock cannot be negative");
		}
	}

	private ProductResponse toProductResponse(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getStock(),
				product.getCategory(), product.isAvailable());
	}

}
