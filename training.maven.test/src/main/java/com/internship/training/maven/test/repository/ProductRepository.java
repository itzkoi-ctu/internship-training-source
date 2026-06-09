package com.internship.training.maven.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.internship.training.maven.test.model.Product;

@Repository
public class ProductRepository {
	private final List<Product> products = new ArrayList<>();
    private int currentId = 1;

    public Product save(Product product) {
        product.setId(currentId);
        currentId++;
        products.add(product);
        return product;
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void delete(Product product) {
        products.remove(product);
    }

}
