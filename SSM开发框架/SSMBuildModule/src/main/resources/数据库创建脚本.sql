-- 删除数据库
DROP DATABASE IF EXISTS ssmbuild;
-- 创建数据库
CREATE DATABASE ssmbuild CHARACTER SET UTF8;
-- 使用数据库
USE ssmbuild;
-- 删除数据表
DROP TABLE IF EXISTS books;
-- 创建数据表
CREATE TABLE books(
	bookID		INT             AUTO_INCREMENT,
	bookName	VARCHAR(50)     NOT NULL,
	bookCounts  INT             NOT NULL,
	details     VARCHAR(200),
	CONSTRAINT	pk_id	PRIMARY KEY(bookID)
);
INSERT INTO books(bookID, bookName, bookCounts, details) VALUES (1, 'Java', 1, '从入门到放弃');
INSERT INTO books(bookID, bookName, bookCounts, details) VALUES (2, 'MySQL', 10, '从删库到跑路');
INSERT INTO books(bookID, bookName, bookCounts, details) VALUES (3, 'Linux', 5, '从进门到进牢');