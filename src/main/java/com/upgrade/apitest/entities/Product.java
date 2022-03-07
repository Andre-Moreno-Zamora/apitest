package com.upgrade.apitest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
	private Long id;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_gpu_memory")
	private String memory;
	@Column(name = "manufacturer_id")
	private Long manufacturerId;
	
	public Product() {
		
	}
	
	public Product(String name,
					String memory,
					Long manufacturerId) {
		this.name = name;
		this.memory = memory;
		this.manufacturerId = manufacturerId;
	}
	
	public Product(Long id, 
					String name,
					String memory,
					Long manufacturerId) {
		this.id = id;
		this.name = name;
		this.memory = memory;
		this.manufacturerId = manufacturerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", memory=" + memory + ", manufacturerId=" + manufacturerId
				+ "]";
	}
	
	
	
}
