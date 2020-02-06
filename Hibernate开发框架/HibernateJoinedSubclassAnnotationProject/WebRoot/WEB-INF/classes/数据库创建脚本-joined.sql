-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 删除数据表
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS member;
-- 创建数据表
CREATE TABLE member(
	mid			VARCHAR(50),
	name 		VARCHAR(50),
	age 		INT,
	CONSTRAINT	pk_mid	PRIMARY KEY(mid)	
);
CREATE TABLE student(
	mid			VARCHAR(50),
	school		VARCHAR(50),
	score		DOUBLE,
	CONSTRAINT	pk_mid1	PRIMARY KEY(mid),
	CONSTRAINT fk_mid1 FOREIGN KEY(mid) REFERENCES member(mid) ON DELETE CASCADE
);
CREATE TABLE worker(
	mid			VARCHAR(50),
	company		VARCHAR(50),
	salary		DOUBLE,
	CONSTRAINT	pk_mid2	PRIMARY KEY(mid),	
	CONSTRAINT fk_mid2 FOREIGN KEY(mid) REFERENCES member(mid) ON DELETE CASCADE
);