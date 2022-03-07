package com.upgrade.apitest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upgrade.apitest.services.IManufacturersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/manufacturers")
public class ApiController {
	
	@Autowired
	private IManufacturersService manufacturersService;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> index() {
		
		return ResponseEntity.ok(this.manufacturersService.findAll());
	
	}
	
	@GetMapping(value = "/by/{manufacturer_name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findByManufacturerName(@PathVariable("manufacturer_name") String manufacturerName){
		return ResponseEntity.ok(this.manufacturersService.findByManufacturerName(manufacturerName));
	}
	
}
