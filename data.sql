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

INSERT INTO manufacturer VALUES(1, 'NVIDIA');
INSERT INTO manufacturer VALUES(2, 'AMD');

INSERT INTO product VALUES(1, 'NVIDIA GEFORCE RTX 3070', '8 GB', 1);
INSERT INTO product VALUES(2, 'NVIDIA GEFORCE RTX 3080', '10 GB', 1);
INSERT INTO product VALUES(3, 'AMD RADEON RX 6600', '8 GB', 2);
INSERT INTO product VALUES(4, 'AMD RADEON RX 6700 RX', '12 GB', 2);