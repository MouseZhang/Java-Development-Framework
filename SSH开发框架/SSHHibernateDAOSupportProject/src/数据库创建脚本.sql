-- 删除数据库
DROP DATABASE IF EXISTS springdb;
-- 创建数据库
CREATE DATABASE springdb CHARACTER SET UTF8;
-- 使用数据库
USE springdb;
-- 删除数据表
DROP TABLE IF EXISTS news;
-- 创建数据表
CREATE TABLE news(
	nid			INT			AUTO_INCREMENT,
	title		VARCHAR(50),
	pubdate		DATE,
	content		TEXT,
	CONSTRAINT	pk_nid	PRIMARY KEY(nid)	
);