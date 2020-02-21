-- 删除数据库
DROP DATABASE IF EXISTS ssm;
-- 创建数据库
CREATE DATABASE ssm CHARACTER SET UTF8;
-- 使用数据库
USE ssm;
-- 删除数据表
DROP TABLE IF EXISTS dept;
DROP TABLE IF EXISTS emp;
-- 创建数据表
CREATE TABLE dept(
	deptno		INT			AUTO_INCREMENT,
	dname		VARCHAR(50),
	CONSTRAINT	pk_deptno	PRIMARY KEY(deptno)	
);
CREATE TABLE emp(
	empno		INT			AUTO_INCREMENT,
	ename		VARCHAR(50),
	sex			CHAR(1),
	email		VARCHAR(50),
	dno		INT,
	CONSTRAINT	pk_empno	PRIMARY KEY(empno),
	CONSTRAINT fk_dno FOREIGN KEY(dno) REFERENCES dept(deptno) ON DELETE SET NULL
);