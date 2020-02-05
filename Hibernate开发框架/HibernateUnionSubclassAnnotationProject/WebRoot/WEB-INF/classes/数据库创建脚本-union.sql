-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 删除数据表
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS worker;
-- 创建数据表
CREATE TABLE student(
	mid			VARCHAR(50),
	name 		VARCHAR(50),
	age 		INT,
	school		VARCHAR(50),
	score		DOUBLE,
	CONSTRAINT	pk_mid1	PRIMARY KEY(mid)	
);
CREATE TABLE worker(
	mid			VARCHAR(50),
	name 		VARCHAR(50),
	age 		INT,
	company		VARCHAR(50),
	salary		DOUBLE,
	CONSTRAINT	pk_mid2	PRIMARY KEY(mid)	
);