package com.upgrade.apitest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="manufacturers")
public class Manufacturers implements Serializable {

	@Id
	@Column(name="manufacturer_id")
	private int id;
	@Column(name="manufacturer_name")
	private String manufacturerName;
	
}
