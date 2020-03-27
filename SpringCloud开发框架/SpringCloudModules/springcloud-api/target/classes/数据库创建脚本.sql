-- 删除数据库
DROP DATABASE IF EXISTS db01;
-- 创建数据库
CREATE DATABASE db01 CHARACTER SET UTF8;
-- 使用数据库
USE db01;
-- 删除数据表
DROP TABLE IF EXISTS dept;
-- 创建数据表
CREATE TABLE dept(
	deptno		BIGINT          AUTO_INCREMENT,
	dname	    VARCHAR(50),
	db_source   VARCHAR(50),
	CONSTRAINT	pk_deptno	PRIMARY KEY(deptno)
);
INSERT INTO dept (dname, db_source) VALUES ('开发部', DATABASE());
INSERT INTO dept (dname, db_source) VALUES ('人事部', DATABASE());
INSERT INTO dept (dname, db_source) VALUES ('财务部', DATABASE());
INSERT INTO dept (dname, db_source) VALUES ('市场部', DATABASE());
INSERT INTO dept (dname, db_source) VALUES ('运维部', DATABASE());