-- 删除数据库
DROP DATABASE IF EXISTS springsecurity;
-- 创建数据库
CREATE DATABASE springsecurity CHARACTER SET UTF8;
-- 使用数据库
USE springsecurity;
-- 删除数据表
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
-- 创建数据表，表名称与表结构必须如下：
CREATE TABLE users(
	username	VARCHAR(50),
	password	VARCHAR(32) NOT NULL,
	enabled		INT,
	CONSTRAINT	pk_username	PRIMARY KEY(username)	
);
CREATE TABLE authorities(
	username	VARCHAR(50),
	authority	VARCHAR(50),
	CONSTRAINT	fk_username FOREIGN KEY(username) REFERENCES users(username) ON DELETE CASCADE
);
-- 增加用户信息，admin/hello
INSERT INTO users(username,password,enabled) VALUES('admin','5d41402abc4b2a76b9719d911017c592',1);
-- 增加用户信息，ustb/java
INSERT INTO users(username,password,enabled) VALUES('ustb','93f725a07423fe1c889f448b33d21f46',1);
-- 增加角色信息
INSERT INTO authorities(username,authority)	VALUES('admin','ROLE_ADMIN');
INSERT INTO authorities(username,authority)	VALUES('admin','ROLE_USER');
INSERT INTO authorities(username,authority)	VALUES('ustb','ROLE_USER');