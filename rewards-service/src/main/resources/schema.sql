DROP TABLE IF EXISTS customer;  
CREATE TABLE customer (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
name VARCHAR(50) NOT NULL  
); 

DROP TABLE IF EXISTS transaction;  
CREATE TABLE transaction (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
customer_id INT NOT NULL ,
amount DECIMAL(10, 2) NOT NULL,
date DATE NOT NULL
);    
