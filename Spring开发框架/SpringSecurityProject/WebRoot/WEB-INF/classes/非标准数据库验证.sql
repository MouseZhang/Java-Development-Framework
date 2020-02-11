-- 删除数据库
DROP DATABASE IF EXISTS springsecurity;
-- 创建数据库
CREATE DATABASE springsecurity CHARACTER SET UTF8;
-- 使用数据库
USE springsecurity;
-- 删除数据表
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS member;
-- 创建数据表，表名称与表结构必须如下：
CREATE TABLE member(
	mid	VARCHAR(50),
	password	VARCHAR(32) NOT NULL,
	enabled		INT,
	CONSTRAINT	pk_mid	PRIMARY KEY(mid)	
);
CREATE TABLE role(
	mid	VARCHAR(50),
	title	VARCHAR(50),
	CONSTRAINT	fk_mid FOREIGN KEY(mid) REFERENCES member(mid) ON DELETE CASCADE
);
-- 增加用户信息，admin/hello
INSERT INTO member(mid,password,enabled) VALUES('admin','5d41402abc4b2a76b9719d911017c592',1);
-- 增加用户信息，ustb/java
INSERT INTO member(mid,password,enabled) VALUES('ustb','93f725a07423fe1c889f448b33d21f46',1);
-- 增加角色信息
INSERT INTO role(mid,title)	VALUES('admin','ROLE_ADMIN');
INSERT INTO role(mid,title)	VALUES('admin','ROLE_USER');
INSERT INTO role(mid,title)	VALUES('ustb','ROLE_USER');