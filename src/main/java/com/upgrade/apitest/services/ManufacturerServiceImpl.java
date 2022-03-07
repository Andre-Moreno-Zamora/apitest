package com.upgrade.apitest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgrade.apitest.dto.ManufacturersDTO;
import com.upgrade.apitest.entities.Manufacturer;
import com.upgrade.apitest.repositories.ManufacturerRepository;
import com.upgrade.apitest.utilities.MHelpers;

@Component
public class ManufacturerServiceImpl implements IManufacturerService{

	private ManufacturerRepository manufacturerRepository;

	@Autowired
	public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
		this.manufacturerRepository = manufacturerRepository;
	}
	
	@Override
	public List<Manufacturer> getManufacturers() {
		return manufacturerRepository.findAll();
	}

	@Override
	public void addNewManufacturer(Manufacturer manufacturer) {
		Optional<Manufacturer> manufacturerOptional = manufacturerRepository
				.findManufacturerByName(manufacturer.getManufacturerName());
		if(manufacturerOptional.isPresent()) {
			throw new IllegalStateException("Name taken");
		}
		manufacturerRepository.save(manufacturer);
		
	}

	@Override
	public void deleteManufacturer(Long manufacturerId) {
		boolean exists = manufacturerRepository.existsById(manufacturerId);
		if(!exists) {
			throw new IllegalStateException("manufacturer with id " + manufacturerId + " does not exists");
		}
		manufacturerRepository.deleteById(manufacturerId);
	}

	@Override
	@Transactional
	public void updateManufacturer(Long manufacturerId, String manufacturerName) {
		Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId)
				.orElseThrow(() -> new IllegalStateException(
						"manufacturer with id " + manufacturerId + " does not exists"));
		if(manufacturerName != null &&
				manufacturerName.length() > 0 &&
				!Objects.equals(manufacturer.getManufacturerName(), manufacturerName)) {
			manufacturer.setManufacturerName(manufacturerName);
		}
	}
	

}
