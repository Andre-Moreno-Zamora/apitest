package com.upgrade.apitest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upgrade.apitest.entities.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
	
	@Query("SELECT m FROM Manufacturer m WHERE m.manufacturerName = ?1")
	Optional<Manufacturer> findManufacturerByName(String manufacturerName);
	
}
