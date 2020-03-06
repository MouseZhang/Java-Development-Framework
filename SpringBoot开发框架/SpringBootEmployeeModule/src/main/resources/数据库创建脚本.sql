-- 删除数据库
DROP DATABASE IF EXISTS springboot;
-- 创建数据库
CREATE DATABASE springboot CHARACTER SET UTF8;
-- 使用数据库
USE springboot;
-- 删除数据表
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employee;
-- 创建数据表
CREATE TABLE department(
	deptno		INT             AUTO_INCREMENT,
	dname		VARCHAR(50),
	CONSTRAINT	pk_deptno	PRIMARY KEY(deptno)
);
CREATE TABLE employee(
    empno		INT             AUTO_INCREMENT,
    ename		VARCHAR(50),
    email		VARCHAR(50),
    gender      INT,
    birth       DATETIME,
    deptno      INT,
    CONSTRAINT	pk_empno	PRIMARY KEY(empno),
    CONSTRAINT  fk_deptno   FOREIGN KEY(deptno) REFERENCES department(deptno) ON DELETE SET NULL
);
INSERT INTO department(deptno, dname) VALUES (101, '开发部');
INSERT INTO department(deptno, dname) VALUES (102, '运营部');
INSERT INTO department(deptno, dname) VALUES (103, '维护部');
INSERT INTO department(deptno, dname) VALUES (104, '数据部');
INSERT INTO department(deptno, dname) VALUES (105, '人力部');
INSERT INTO employee(empno, ename, email, gender, birth, deptno) VALUES (1001, 'SMITH', 'smith@163.com', 1, '1990-10-01', 101);
INSERT INTO employee(empno, ename, email, gender, birth, deptno) VALUES (1002, 'JONE', 'jone@126.com', 0, '1992-04-02', 102);
INSERT INTO employee(empno, ename, email, gender, birth, deptno) VALUES (1003, 'ALLEN', 'allen@qq.com', 0, '1988-12-11', 103);
INSERT INTO employee(empno, ename, email, gender, birth, deptno) VALUES (1004, 'KING', 'king@gmail.com', 1, '1999-11-11', 104);
INSERT INTO employee(empno, ename, email, gender, birth, deptno) VALUES (1005, 'LEE', 'lee@163.com', 1, '1996-02-28', 105);
commit;