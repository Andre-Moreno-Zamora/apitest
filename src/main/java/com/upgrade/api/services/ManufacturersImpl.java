package com.upgrade.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgrade.apitest.dto.ManufacturersDTO;
import com.upgrade.apitest.entities.Manufacturers;
import com.upgrade.apitest.repositories.ManufacturersRepository;
import com.upgrade.apitest.utilities.MHelpers;

@Component
public class ManufacturersImpl implements IManufacturersService{

	@Autowired
	private ManufacturersRepository manufacturersRepository;
	
	@Override
	public List<ManufacturersDTO> findAll() {
		
		List<ManufacturersDTO> dto = new ArrayList<>();
		
		Iterable<Manufacturers> manufacturers = this.manufacturersRepository.findAll();
		
		for(Manufacturers manufacturer : manufacturers) {
			
			ManufacturersDTO manufacturersDTO = MHelpers.modelMapper().map(manufacturers, ManufacturersDTO.class);
			
			dto.add(manufacturersDTO);
			
		}
		
		return dto;
		
	}

	@Override
	public ManufacturersDTO findByManufacturerName(String manufacturerName) {
		
		Optional<Manufacturers> manufacturer = manufacturersRepository.findByManufacturerName(manufacturerName);
		
		if( !manufacturer.isPresent() ) {
			return null;
		}
		
		return MHelpers.modelMapper().map(manufacturer.get(), ManufacturersDTO.class);
		
	}

	@Override
	public ManufacturersDTO findByManufacturerId(int manufacturerId) {
		
		Optional<Manufacturers> manufacturer = manufacturersRepository.findById(manufacturerId);
		
		if( !manufacturer.isPresent() ) {
			return null;
		}
		return MHelpers.modelMapper().map(manufacturer.get(), ManufacturersDTO.class);
	}

	@Override
	public void save(ManufacturersDTO manufacturer) {
		
		Manufacturers manufacturers = MHelpers.modelMapper().map(manufacturer, Manufacturers.class);
		
		this.manufacturersRepository.save(manufacturers);
		
	}

	@Override
	public void saveAll(List<ManufacturersDTO> manufacturers) {
		
		List<Manufacturers> m = new ArrayList<>();
		
		for(ManufacturersDTO manufacturer : manufacturers) {
			
			Manufacturers ms = MHelpers.modelMapper().map(manufacturer, Manufacturers.class);
			
			m.add(ms);
			
		}
		
		this.manufacturersRepository.saveAll(m);
		
	}

	@Override
	public void deleteById(int manufacturerId) {
		
		this.manufacturersRepository.deleteById(manufacturerId);
		
	}
	
	private ManufacturersDTO convertToManufacturersDTO(final Manufacturers manufacturers) {
		
		return MHelpers.modelMapper().map(manufacturers, ManufacturersDTO.class);
		
	}

}
