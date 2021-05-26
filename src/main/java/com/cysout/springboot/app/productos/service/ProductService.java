package com.cysout.springboot.app.productos.service;

import java.util.List;

import com.cysout.springboot.app.productos.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product findById(Long id);
}
