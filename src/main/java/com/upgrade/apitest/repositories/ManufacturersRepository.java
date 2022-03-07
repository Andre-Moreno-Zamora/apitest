package com.upgrade.apitest.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upgrade.apitest.entities.Manufacturer;

@Repository
public interface ManufacturersRepository extends CrudRepository<Manufacturer, Long> {
	
	@Transactional(readOnly=true)
	Optional<Manufacturer> findByManufacturerName(String manufacturerName);
	
}
