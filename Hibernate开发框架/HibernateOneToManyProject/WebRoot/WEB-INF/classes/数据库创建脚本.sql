-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 删除数据表
DROP TABLE IF EXISTS subitem;
DROP TABLE IF EXISTS item;
-- 创建数据表
CREATE TABLE item(
	iid			INT		AUTO_INCREMENT,
	title		VARCHAR(50),
	CONSTRAINT	pk_iid	PRIMARY KEY(iid)	
);
CREATE TABLE subitem(
	sid			INT		AUTO_INCREMENT,
	title		VARCHAR(50),
	iid			INT,
	CONSTRAINT	pk_sid	PRIMARY KEY(sid),
	CONSTRAINT	fk_iid	FOREIGN KEY(iid) REFERENCES item(iid) ON DELETE CASCADE
);