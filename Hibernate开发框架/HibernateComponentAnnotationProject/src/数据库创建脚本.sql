-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 删除数据表
DROP TABLE IF EXISTS member;
-- 创建数据表
CREATE TABLE member(
	mid			VARCHAR(50),
	name 		VARCHAR(50),
	age 		INT,
	birthday	DATE,
	address		VARCHAR(100),
	zipcode		VARCHAR(8),
	phone		VARCHAR(50),
	CONSTRAINT	pk_mid	PRIMARY KEY(mid)	
);