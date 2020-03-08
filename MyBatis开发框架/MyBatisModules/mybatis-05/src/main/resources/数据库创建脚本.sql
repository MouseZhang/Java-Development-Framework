-- 删除数据库
DROP DATABASE IF EXISTS mybatis;
-- 创建数据库
CREATE DATABASE mybatis CHARACTER SET UTF8;
-- 使用数据库
USE mybatis;
-- 删除数据表
DROP TABLE IF EXISTS user;
-- 创建数据表
CREATE TABLE user(
	id		INT             AUTO_INCREMENT,
	name	VARCHAR(50)     NOT NULL,
	pwd	VARCHAR(32)     NOT NULL,
	CONSTRAINT	pk_id	PRIMARY KEY(id)
);
INSERT INTO user(name, pwd) VALUES ('admin', 'hello');
INSERT INTO user(name, pwd) VALUES ('ustb', 'java');
INSERT INTO user(name, pwd) VALUES ('root', 'root123');