package com.cysout.springboot.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cysout.springboot.app.productos.entity.Product;
import com.cysout.springboot.app.productos.service.ProductService;

@RestController
public class ProductController {
	
	/*@Autowired
	private Environment env;*/
	
	@Value("${server.port}")
	private Integer port;
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/listar")
	public List<Product> listar(){
		//return productService.findAll();
		return productService.findAll().stream().map(product -> {
			//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/detalle/{id}")
	public Product detalle(@PathVariable Long id) {
		Product product = productService.findById(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		product.setPort(port);
		return product;
	}
}
