CREATE TABLE manufacturer(
	manufacturer_id int NOT NULL auto_increment,
	manufacturer_name varchar(20) NOT NULL,
	CONSTRAINT manufacturer_pk PRIMARY KEY (manufacturer_id)
);

CREATE TABLE product(
	product_id int NOT NULL auto_increment,
	product_name varchar(30) NOT NULL,
	product_gpu_memory varchar(20) NOT NULL,
	manufacturer_id int NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY (product_id),
	CONSTRAINT product_fk FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id)
);
