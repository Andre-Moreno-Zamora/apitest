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
import com.upgrade.apitest.services.IProductService;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
	
	private final IProductService productService;
	
	@Autowired
	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping(path = "clone/{productId}")
	public List<Product> getProductClone(
			@PathVariable("productId") Long productId){
		return productService.getProductClone(productId);
	}

	@PostMapping
	public void registerNewProduct(@RequestBody Product product) {
		productService.addNewProduct(product);
	}
	
	@DeleteMapping(path = "{productId}")
	public void deleteProduct(
			@PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
	}
	
	@PutMapping(path = "{productId}")
	public void updateProduct(
			@PathVariable("productId") Long productId,
			@RequestParam(required = false) String name) {
		productService.updateProduct(productId, name);
	}
	
}
