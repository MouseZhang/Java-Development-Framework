-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 删除数据表
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS member;
-- 创建数据表
CREATE TABLE member(
	mid			VARCHAR(50),
	name 		VARCHAR(50),
	CONSTRAINT	pk_mid	PRIMARY KEY(mid)	
);
CREATE TABLE email(
	mid			VARCHAR(50),
	title 		VARCHAR(10),
	age 		INT,
	CONSTRAINT	fk_mid	FOREIGN KEY(mid) REFERENCES member(mid) ON DELETE CASCADE	
);