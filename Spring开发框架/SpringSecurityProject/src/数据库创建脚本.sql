-- 删除数据库
DROP DATABASE IF EXISTS springsecurity;
-- 创建数据库
CREATE DATABASE springsecurity CHARACTER SET UTF8;
-- 使用数据库
USE springsecurity;
-- 删除数据表
DROP TABLE IF EXISTS persistent_logins;
-- 创建数据表，表名称与表结构必须如下：
CREATE TABLE persistent_logins(
	series		VARCHAR(64),
	username	VARCHAR(100)	NOT NULL,
	token		VARCHAR(64),
	last_used	DATETIME,
	CONSTRAINT	pk_series	PRIMARY KEY(series)	
);