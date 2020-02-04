-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 删除数据表
DROP TABLE IF EXISTS news;
-- 创建数据表
CREATE TABLE news(
	nid 		INT			AUTO_INCREMENT,
	title		VARCHAR(50)	NOT NULL,
	visits		INT,
	item		VARCHAR(50),
	CONSTRAINT pk_nid	PRIMARY KEY(nid)
);