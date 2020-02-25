-- 删除数据库
DROP DATABASE IF EXISTS springboot;
-- 创建数据库
CREATE DATABASE springboot CHARACTER SET UTF8;
-- 使用数据库
USE springboot;
-- 删除数据表
DROP TABLE IF EXISTS user;
-- 创建数据表
CREATE TABLE user(
	id		    INT             AUTO_INCREMENT,
	name		VARCHAR(50),
	password	VARCHAR(50),
	CONSTRAINT	pk_id	PRIMARY KEY(id)
);
INSERT INTO user (name, password) VALUES ('SMITH', '12345');
INSERT INTO user (name, password) VALUES ('ALLEN', 'abcde');
INSERT INTO user (name, password) VALUES ('KING', 'hello');
INSERT INTO user (name, password) VALUES ('JONE', '11111');
INSERT INTO user (name, password) VALUES ('LEE', '123abc');
commit;