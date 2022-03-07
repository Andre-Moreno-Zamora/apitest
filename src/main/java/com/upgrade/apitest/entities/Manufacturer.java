package com.upgrade.apitest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="manufacturer")
public class Manufacturer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="manufacturer_id")
	private Long id;
	@Column(name="manufacturer_name")
	private String manufacturerName;
	
	public Manufacturer() {
		
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
	
}
