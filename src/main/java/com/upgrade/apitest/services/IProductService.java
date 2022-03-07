package com.upgrade.apitest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upgrade.apitest.entities.Product;

@Service
public interface IProductService {

	List<Product> getProducts();
	
	void addNewProduct(Product product);
	
	void deleteProduct(Long productId);
	
	void updateProduct(Long productId, String name);
	
}
