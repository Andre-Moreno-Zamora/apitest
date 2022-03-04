package com.upgrade.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.upgrade.apitest.dto.ManufacturersDTO;

@Service
public interface IManufacturersService {

	List<ManufacturersDTO> findAll();
	
	ManufacturersDTO findByManufacturerName(String manufacturerName);
	
	ManufacturersDTO findByManufacturerId(int manufacturerId);
	
	void save(ManufacturersDTO manufacturer);
	
	void saveAll(List<ManufacturersDTO> manufacturers);
	
	void deleteById(int manufacturerId);
}
