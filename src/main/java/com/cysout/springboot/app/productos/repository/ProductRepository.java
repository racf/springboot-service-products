package com.cysout.springboot.app.productos.repository;

import org.springframework.data.repository.CrudRepository;

import com.cysout.springboot.app.productos.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
