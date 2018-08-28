IF NOT EXISTS (
SELECT  schema_name
FROM    information_schema.schemata
WHERE   schema_name = 'java2' )
BEGIN
EXEC ('CREATE SCHEMA [java2] AUTHORIZATION [dbo]');
END

USE java2;

DROP TABLE IF EXISTS contract;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id BIGINT CONSTRAINT customer_pk PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  balance FLOAT NOT NULL
);

CREATE TABLE car (
  id BIGINT  CONSTRAINT car_pk PRIMARY KEY,
  manufacturer VARCHAR(50) NOT NULL,
  price FLOAT NOT NULL
);

CREATE TABLE contract (
  id BIGINT NOT NULL IDENTITY(1,1) CONSTRAINT contract_pk PRIMARY KEY,
  carId BIGINT NOT NULL,
  customerId BIGINT NOT NULL,
  expired INTEGER,
  contractDate DATETIME NOT NULL DEFAULT (GETDATE()),
  CONSTRAINT customer_fk FOREIGN KEY (customerId) REFERENCES customer (id),
  CONSTRAINT car_fk FOREIGN KEY (carId) REFERENCES car (id)
);

INSERT INTO customer(id, first_name, last_name, balance) VALUES(1, 'Bill', 'Gates', 1000);
INSERT INTO car(id, manufacturer, price) VALUES(1, 'Car1', 20);
INSERT INTO car(id, manufacturer, price) VALUES(2, 'Car2', 40);
INSERT INTO car(id, manufacturer, price) VALUES(3, 'Car3', 60);
