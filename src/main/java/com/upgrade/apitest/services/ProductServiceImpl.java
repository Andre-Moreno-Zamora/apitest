package com.upgrade.apitest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrade.apitest.entities.Product;
import com.upgrade.apitest.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> getProductClone(Long productId){
		boolean exists = productRepository.existsById(productId);
		
		if(!exists) {
			throw new IllegalStateException("product with id " + productId + " does not exists");
		}
		
		Optional<Product> productOptional = productRepository
				.findById(productId);
		
		List<Product> clonedProductList = new ArrayList<Product>();
		Product productToClone = productOptional.get();
		Product productClone = (Product) productToClone.cloneProduct();
		
		clonedProductList.add(productClone);
		
		return clonedProductList;
	}
	
	@Override
	public void addNewProduct(Product product) {
		Optional<Product> productOptional = productRepository
				.findProductByName(product.getName());
		if(productOptional.isPresent()) {
			throw new IllegalStateException("Name taken");
		}
		productRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Long productId) {
		boolean exists = productRepository.existsById(productId);
		if(!exists) {
			throw new IllegalStateException("product with id " + productId + " does not exists");
		}
		productRepository.deleteById(productId);
	}
	
	@Override
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
