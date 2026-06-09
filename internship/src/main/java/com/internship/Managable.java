package com.internship;

import java.util.List;

import com.model.Product;

public interface Managable<T> {
	void add(T item);
	
	void update(T item);

	void deleteById(int id);

	T findById(int id);

	List<T> findAll();

}
