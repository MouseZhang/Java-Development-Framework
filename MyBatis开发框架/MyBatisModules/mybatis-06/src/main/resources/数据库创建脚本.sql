-- 删除数据库
DROP DATABASE IF EXISTS mybatis;
-- 创建数据库
CREATE DATABASE mybatis CHARACTER SET UTF8;
-- 使用数据库
USE mybatis;
-- 删除数据表
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS student;
-- 创建数据表
CREATE TABLE teacher(
	tid		INT,
	name	VARCHAR(50)     DEFAULT NULL,
	CONSTRAINT	pk_tid	PRIMARY KEY(tid)
);
CREATE TABLE student(
	sid		INT,
	name	VARCHAR(50)     DEFAULT NULL,
	tid     INT             DEFAULT NULL,
	CONSTRAINT	pk_sid	PRIMARY KEY(sid),
	CONSTRAINT  fk_tid   FOREIGN KEY(tid) REFERENCES teacher(tid) ON DELETE SET NULL
);
INSERT INTO teacher(tid, name) VALUES (1, 'SMITH');
INSERT INTO student(sid, name, tid) VALUES (1, 'ALLEN', 1);
INSERT INTO student(sid, name, tid) VALUES (2, 'LEE', 1);
INSERT INTO student(sid, name, tid) VALUES (3, 'JONE', 1);