create table manufacturers(
	manufacturer_id int NOT NULL auto_increment,
	manufacturer_name varchar(20) NOT NULL,
	CONSTRAINT manufacturers_pk PRIMARY KEY (manufacturer_id)
);

CREATE TABLE products(
	product_id int NOT NULL auto_increment,
	product_name varchar(30) NOT NULL,
	product_gpu_memory varchar(20) NOT NULL,
	manufacturer_id int NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY (product_id),
	CONSTRAINT product_fk FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(manufacturer_id)
);

INSERT INTO manufacturers VALUES(1, 'NVIDIA');
INSERT INTO manufacturers VALUES(2, 'AMD');

INSERT INTO products VALUES(1, 'NVIDIA GEFORCE RTX 3070', '8 GB', 1);
INSERT INTO products VALUES(2, 'NVIDIA GEFORCE RTX 3080', '10 GB', 1);
INSERT INTO products VALUES(3, 'AMD RADEON RX 6600', '8 GB', 2);
INSERT INTO products VALUES(4, 'AMD RADEON RX 6700 RX', '12 GB', 2);