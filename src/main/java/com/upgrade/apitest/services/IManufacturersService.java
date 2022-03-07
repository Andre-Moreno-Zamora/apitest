package com.upgrade.apitest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upgrade.apitest.dto.ManufacturersDTO;

@Service
public interface IManufacturersService {

	List<ManufacturersDTO> findAll();
	
	ManufacturersDTO findByManufacturerName(String manufacturerName);
	
	ManufacturersDTO findByManufacturerId(Long manufacturerId);
	
	void save(ManufacturersDTO manufacturer);
	
	void saveAll(List<ManufacturersDTO> manufacturers);
	
	void deleteById(Long manufacturerId);
}
