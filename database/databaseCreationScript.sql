IF NOT EXISTS (
SELECT  schema_name
FROM    information_schema.schemata
WHERE   schema_name = 'java2' )
BEGIN
EXEC ('CREATE SCHEMA [java2] AUTHORIZATION [dbo]');
END

USE [java2];

DROP TABLE IF EXISTS [car];
DROP TABLE IF EXISTS [customer];

CREATE TABLE car (
  [id] BIGINT NOT NULL IDENTITY,
  [name] VARCHAR(50) NOT NULL,
  [price] FLOAT NOT NULL,
  [rented] INT NOT NULL,
  PRIMARY KEY ([id])
);

INSERT INTO car([name], [price], [rented]) VALUES('Car1', 20, 1);
INSERT INTO car([name], [price], [rented]) VALUES('Car2', 40, 1);
INSERT INTO car([name], [price], [rented]) VALUES('Car3', 60, 1);

CREATE TABLE customer (
  [id] BIGINT NOT NULL IDENTITY,
  [name] VARCHAR(50) NOT NULL,
  [money] FLOAT NOT NULL,
  PRIMARY KEY ([id])
);

INSERT INTO customer([name], [money]) VALUES('User1', 100);