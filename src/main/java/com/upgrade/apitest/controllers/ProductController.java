package com.upgrade.apitest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upgrade.apitest.entities.Product;
import com.upgrade.apitest.services.ProductServiceImpl;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
	
	private final ProductServiceImpl productServiceImpl;
	
	@Autowired
	public ProductController(ProductServiceImpl productServiceImpl) {
		this.productServiceImpl = productServiceImpl;
	}

	@GetMapping
	public List<Product> getProducts(){
		return productServiceImpl.getProducts();
	}

	@PostMapping
	public void registerNewProduct(@RequestBody Product product) {
		productServiceImpl.addNewProduct(product);
	}
	
	@DeleteMapping(path = "{productId}")
	public void deleteProduct(
			@PathVariable("productId") Long productId) {
		productServiceImpl.deleteProduct(productId);
	}
	
	@PutMapping(path = "{productId}")
	public void updateProduct(
			@PathVariable("productId") Long productId,
			@RequestParam(required = false) String name) {
		productServiceImpl.updateProduct(productId, name);
	}
	
}
