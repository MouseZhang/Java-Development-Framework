-- 删除数据库
DROP DATABASE IF EXISTS hdb;
-- 创建数据库
CREATE DATABASE hdb CHARACTER SET UTF8;
-- 使用数据库
USE hdb;
-- 1、删除数据表 角色权限组表 
DROP TABLE IF EXISTS role_groups ;
-- 2、删除数据表 角色表
DROP TABLE IF EXISTS role;
-- 3、删除数据表 权限组表
DROP TABLE IF EXISTS groups;

-- 创建权限组信息表 
CREATE TABLE groups (
	gid			INT 		AUTO_INCREMENT,
	title		VARCHAR(50),
	note		TEXT,
	CONSTRAINT pk_gid PRIMARY KEY(gid)
);
-- 创建角色表
CREATE TABLE role (
	rid			INT			AUTO_INCREMENT,
	title		VARCHAR(50)	NOT NULL,
	note		TEXT,
	CONSTRAINT pk_rid PRIMARY KEY(rid)
);
-- 创建角色-权限关系表
CREATE TABLE role_groups (
	rid			INT,
	gid			INT,
	CONSTRAINT fk_rid1 FOREIGN KEY(rid) REFERENCES role(rid) ON DELETE CASCADE,
	CONSTRAINT fk_gid1 FOREIGN KEY(gid) REFERENCES groups(gid) ON DELETE CASCADE
);
-- 测试数据 权限组
INSERT INTO groups(title,note) VALUES ('权限管理','-');
INSERT INTO groups(title,note) VALUES ('信息管理','-');
INSERT INTO groups(title,note) VALUES ('课程管理','-');
INSERT INTO groups(title,note) VALUES ('人事管理','-');

-- 测试数据 角色信息
INSERT INTO role(title,note) VALUES ('超级管理员组','-');
INSERT INTO role(title,note) VALUES ('普通管理员组','-');

-- 测试数据 管理员-权限组关系
INSERT INTO role_groups(rid,gid) VALUES (1,1) ;
INSERT INTO role_groups(rid,gid) VALUES (1,2) ;
INSERT INTO role_groups(rid,gid) VALUES (1,3) ;
INSERT INTO role_groups(rid,gid) VALUES (1,4) ;
INSERT INTO role_groups(rid,gid) VALUES (2,2) ;
INSERT INTO role_groups(rid,gid) VALUES (2,3) ;
INSERT INTO role_groups(rid,gid) VALUES (2,4) ;

-- 多对多最常见的流程，要确定主控方，具体就是：权限组信息自己进行维护的时候（group），不应该与角色发生关系；
-- 在角色进行维护的时候必须要考虑权限组的情况（role为主控方，主要维护中间的关系表）