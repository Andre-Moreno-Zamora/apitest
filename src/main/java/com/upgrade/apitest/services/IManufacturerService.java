package com.upgrade.apitest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upgrade.apitest.entities.Manufacturer;

@Service
public interface IManufacturerService {

	List<Manufacturer> getManufacturers();
	
	void addNewManufacturer(Manufacturer manufacturer);
	
	void deleteManufacturer(Long manufacturerId);
	
	void updateManufacturer(Long manufacturerId, String manufacturerName);
	
}
