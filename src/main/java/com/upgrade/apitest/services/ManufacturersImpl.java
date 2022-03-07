package com.upgrade.apitest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgrade.apitest.dto.ManufacturersDTO;
import com.upgrade.apitest.entities.Manufacturer;
import com.upgrade.apitest.repositories.ManufacturersRepository;
import com.upgrade.apitest.utilities.MHelpers;

@Component
public class ManufacturersImpl implements IManufacturersService{

	@Autowired
	private ManufacturersRepository manufacturersRepository;
	
	@Override
	public List<ManufacturersDTO> findAll() {
		
		List<ManufacturersDTO> dto = new ArrayList<>();
		
		Iterable<Manufacturer> manufacturers = this.manufacturersRepository.findAll();
		
		for(Manufacturer manufacturer : manufacturers) {
			
			ManufacturersDTO manufacturersDTO = MHelpers.modelMapper().map(manufacturer, ManufacturersDTO.class);
			
			dto.add(manufacturersDTO);
			
		}
		
		return dto;
		
	}

	@Override
	public ManufacturersDTO findByManufacturerName(String manufacturerName) {
		
		Optional<Manufacturer> manufacturer = manufacturersRepository.findByManufacturerName(manufacturerName);
		
		if( !manufacturer.isPresent() ) {
			return null;
		}
		
		return MHelpers.modelMapper().map(manufacturer.get(), ManufacturersDTO.class);
		
	}

	@Override
	public ManufacturersDTO findByManufacturerId(Long manufacturerId) {
		
		Optional<Manufacturer> manufacturer = manufacturersRepository.findById(manufacturerId);
		
		if( !manufacturer.isPresent() ) {
			return null;
		}
		return MHelpers.modelMapper().map(manufacturer.get(), ManufacturersDTO.class);
	}

	@Override
	public void save(ManufacturersDTO manufacturer) {
		
		Manufacturer manufacturers = MHelpers.modelMapper().map(manufacturer, Manufacturer.class);
		
		this.manufacturersRepository.save(manufacturers);
		
	}

	@Override
	public void saveAll(List<ManufacturersDTO> manufacturers) {
		
		List<Manufacturer> m = new ArrayList<>();
		
		for(ManufacturersDTO manufacturer : manufacturers) {
			
			Manufacturer ms = MHelpers.modelMapper().map(manufacturer, Manufacturer.class);
			
			m.add(ms);
			
		}
		
		this.manufacturersRepository.saveAll(m);
		
	}

	@Override
	public void deleteById(Long manufacturerId) {
		
		this.manufacturersRepository.deleteById(manufacturerId);
		
	}

}
