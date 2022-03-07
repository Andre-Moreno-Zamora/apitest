package com.upgrade.apitest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upgrade.apitest.entities.Manufacturer;
import com.upgrade.apitest.services.IManufacturerService;

@RestController
@RequestMapping(path = "api/v1/manufacturer")
public class ManufacturerController {

	private final IManufacturerService manufacturerService;
	
	@Autowired
	public ManufacturerController(IManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}
	
	@GetMapping
	public List<Manufacturer> getManufacturers() {
		return manufacturerService.getManufacturers();
	}
	
	@PostMapping
	public void registerNewManufacturer(@RequestBody Manufacturer manufacturer) {
		manufacturerService.addNewManufacturer(manufacturer);
	}
	
	@DeleteMapping(path = "{manufacturerId}")
	public void deleteManufacturer(
			@PathVariable("manufacturerId") Long manufacturerId) {
		manufacturerService.deleteManufacturer(manufacturerId);
	}
	
	@PutMapping(path = "{manufacturerId}")
	public void updateManufacturer(
			@PathVariable("manufacturerId") Long manufacturerId,
			@RequestParam(required = false) String manufacturerName) {
		manufacturerService.updateManufacturer(manufacturerId, manufacturerName);
	}
}
