package com.upgrade.apitest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upgrade.apitest.entities.Manufacturer;
import com.upgrade.apitest.entities.Product;

@SpringBootApplication
public class ApitestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApitestApplication.class, args);
	}
	
}
