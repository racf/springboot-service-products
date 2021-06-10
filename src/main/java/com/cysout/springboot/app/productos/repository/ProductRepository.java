package com.cysout.springboot.app.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cysout.springboot.app.productos.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{//CrudRepository<Product, Long>{

}
