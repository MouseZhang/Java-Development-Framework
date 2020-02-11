-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 删除数据表
DROP TABLE IF EXISTS member_details;
DROP TABLE IF EXISTS member_login;
-- 创建数据表
CREATE TABLE member_login(
	mid			VARCHAR(50),
	password	VARCHAR(32),
	CONSTRAINT	pk_mid	PRIMARY KEY(mid)	
);
CREATE TABLE member_details(
	mid			VARCHAR(50),
	name		VARCHAR(50),
	email		VARCHAR(50),
	phone		VARCHAR(50),
	CONSTRAINT	pk_mid1	PRIMARY KEY(mid),
	CONSTRAINT	fk_mid	FOREIGN KEY(mid) REFERENCES member_login(mid) ON DELETE CASCADE
);