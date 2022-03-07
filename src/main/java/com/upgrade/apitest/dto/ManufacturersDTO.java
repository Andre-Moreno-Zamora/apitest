package com.upgrade.apitest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@Data
public class ManufacturersDTO implements Serializable {
	
	private String id;
	private String manufacturerName;
	
}
