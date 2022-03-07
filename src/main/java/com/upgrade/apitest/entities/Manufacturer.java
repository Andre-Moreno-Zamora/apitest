package com.upgrade.apitest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer")
public class Manufacturer {
	
	private static Manufacturer instance;
	
	@Id
	@Column(name="manufacturer_id")
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
	private Long id;
	@Column(name="manufacturer_name")
	private String manufacturerName;
	
	private Manufacturer() {
		
	}
	
	// Singleton implementation
	public static Manufacturer getInstance() {
		if(instance == null) {
			instance = new Manufacturer();
		}
		return instance;
	}
	
	public Manufacturer(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
	public Manufacturer(Long id, String manufacturerName) {
		this.id = id;
		this.manufacturerName = manufacturerName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", manufacturerName=" + manufacturerName + "]";
	}
	
}
