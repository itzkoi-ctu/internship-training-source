package com.internship.training.maven.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internship.training.maven.test.dto.request.CreateProductRequest;
import com.internship.training.maven.test.dto.request.UpdateProductRequest;
import com.internship.training.maven.test.dto.response.ProductResponse;

@Service
public interface IProductService {
	ProductResponse createProduct(CreateProductRequest request);
	List<ProductResponse> getAllProducts();
	ProductResponse getProductById(int id);
	ProductResponse updateProduct(int id, UpdateProductRequest request);
	void deleteProduct(int id);
	List<ProductResponse> getAvailableProducts();

}
