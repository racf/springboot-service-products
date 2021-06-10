package com.cysout.springboot.app.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public Product detalle(@PathVariable Long id) throws Exception {
		Product product = productService.findById(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		product.setPort(port);
		
		//Simulando a que se produce el error
		/*boolean ok = false;
		if(ok == false ) {
			throw new Exception("No se pudo cargar el producto");
		}*/
		/*try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		return product;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Product crear(@RequestBody Product product) {
		return productService.save(product);
	}
}
