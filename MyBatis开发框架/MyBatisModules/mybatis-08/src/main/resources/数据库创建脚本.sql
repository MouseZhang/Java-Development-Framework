-- 删除数据库
DROP DATABASE IF EXISTS mybatis;
-- 创建数据库
CREATE DATABASE mybatis CHARACTER SET UTF8;
-- 使用数据库
USE mybatis;
-- 删除数据表
DROP TABLE IF EXISTS blog;
-- 创建数据表
CREATE TABLE blog(
	id		            VARCHAR(50),
	title               VARCHAR(50),
	author              VARCHAR(50),
	createTime          DATETIME,
	views               INT,
	CONSTRAINT	pk_id	PRIMARY KEY(id)
);
INSERT INTO blog (id,title,author,createTime,views) VALUES ()