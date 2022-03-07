package com.upgrade.apitest.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrade.apitest.entities.Product;
import com.upgrade.apitest.repositories.ProductRepository;

@Service
public class ProductServiceImpl {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public void addNewProduct(Product product) {
		Optional<Product> productOptional = productRepository
				.findProductByName(product.getName());
		if(productOptional.isPresent()) {
			throw new IllegalStateException("Name taken");
		}
		productRepository.save(product);
	}
	
	public void deleteProduct(Long productId) {
		boolean exists = productRepository.existsById(productId);
		if(!exists) {
			throw new IllegalStateException("product with id " + productId + " does not exists");
		}
		productRepository.deleteById(productId);
	}
	
	@Transactional
	public void updateProduct(Long productId, String name) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new IllegalStateException(
						"product with id " + productId + " does not exists"));
		
		if(name != null &&
				name.length() > 0 &&
				!Objects.equals(product.getName(), name)) {
			product.setName(name);
		}
	}
	
}
