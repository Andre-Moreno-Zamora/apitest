package com.upgrade.apitest.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.upgrade.apitest.entities.Manufacturers;

@Repository
public interface ManufacturersRepository extends CrudRepository<Manufacturers, Integer> {
	
	@Transactional(readOnly=true)
	Optional<Manufacturers> findByManufacturerName(String manufacturerName);
	
}
