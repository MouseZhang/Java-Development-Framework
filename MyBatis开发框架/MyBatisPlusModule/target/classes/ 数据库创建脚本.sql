-- 删除数据库
DROP DATABASE IF EXISTS mybatis_plus;
-- 创建数据库
CREATE DATABASE mybatis_plus CHARACTER SET UTF8;
-- 使用数据库
USE mybatis_plus;
-- 删除数据表
DROP TABLE IF EXISTS user;
-- 创建数据表
CREATE TABLE user(
	id          BIGINT(20)      COMMENT '主键ID',
	name        VARCHAR(30)     DEFAULT NULL    COMMENT '姓名',
	age         INT(11)         DEFAULT NULL    COMMENT '年龄',
	email       VARCHAR(50)     DEFAULT NULL    COMMENT '邮箱',
    gmt_create  DATETIME        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    gmt_update  DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    CONSTRAINT	pk_id	        PRIMARY KEY(id)
);
-- 插入数据
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');

-- 真实开发中需要添加：version（乐观锁）、deleted（逻辑删除）、gmt_create、gmt_modified

-- 1、上述建表属于数据库级别的操作（时间）：
-- （1）建表的字段
# gmt_create  DATETIME        DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
# gmt_update  DATETIME        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
-- （2）开发即可
#     private Date gmtCreate;
#     private Date gmtUpdate;

-- 2、下面使用代码级别的操作（开发中建议使用）
CREATE TABLE user(
    id          BIGINT(20)      COMMENT '主键ID',
    name        VARCHAR(30)     DEFAULT NULL    COMMENT '姓名',
    age         INT(11)         DEFAULT NULL    COMMENT '年龄',
    email       VARCHAR(50)     DEFAULT NULL    COMMENT '邮箱',
    gmt_create  DATETIME        DEFAULT NULL    COMMENT '创建时间',
    gmt_update  DATETIME        DEFAULT NULL    COMMENT '更新时间',
    CONSTRAINT	pk_id	        PRIMARY KEY(id)
);
-- （1）建表的字段
# gmt_create  DATETIME        DEFAULT NULL    COMMENT '创建时间',
# gmt_update  DATETIME        DEFAULT NULL    COMMENT '更新时间',
-- （2）在实体类上添加注解
# @TableField(fill = FieldFill.INSERT)
#     private Date gmtCreate;
# @TableField(fill = FieldFill.INSERT_UPDATE)
#     private Date gmtUpdate;
-- （3）编写处理器处理注解即可
# 创建MyMetaObjectHandler类

-- 乐观锁
CREATE TABLE user(
    id          BIGINT(20)      COMMENT '主键ID',
    name        VARCHAR(30)     DEFAULT NULL    COMMENT '姓名',
    age         INT(11)         DEFAULT NULL    COMMENT '年龄',
    email       VARCHAR(50)     DEFAULT NULL    COMMENT '邮箱',
    version     INT(11)         DEFAULT '1'     COMMENT '乐观锁',
    gmt_create  DATETIME        DEFAULT NULL    COMMENT '创建时间',
    gmt_update  DATETIME        DEFAULT NULL    COMMENT '更新时间',
    CONSTRAINT	pk_id	        PRIMARY KEY(id)
);
-- （1）建表的字段
# version     INT(11)         DEFAULT '1'     COMMENT '乐观锁',
-- （2）在实体类上添加字段注解
# @Version
# private Integer version;
-- （3）注册组件
# 创建MyBatisPlusConfig类

-- 逻辑删除
CREATE TABLE user(
    id          BIGINT(20)      COMMENT '主键ID',
    name        VARCHAR(30)     DEFAULT NULL    COMMENT '姓名',
    age         INT(11)         DEFAULT NULL    COMMENT '年龄',
    email       VARCHAR(50)     DEFAULT NULL    COMMENT '邮箱',
    version     INT(11)         DEFAULT '1'     COMMENT '乐观锁',
    gmt_create  DATETIME        DEFAULT NULL    COMMENT '创建时间',
    gmt_update  DATETIME        DEFAULT NULL    COMMENT '更新时间',
    deleted     INT(1)          DEFAULT '0'     COMMENT '逻辑删除',
    CONSTRAINT	pk_id	        PRIMARY KEY(id)
);
-- （1）建表的字段
# deleted     INT(1)          DEFAULT '0'     COMMENT '逻辑删除',
-- （2）在实体类上添加字段注解
# @TableLogic
# private Integer deleted;
-- （3）注册组件，注册Bean
# sqlInjector
-- （4）配置逻辑删除
# logic-delete-value: 1
# logic-not-delete-value: 0