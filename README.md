# Java Development Framework

# Java后台开发框架

## SSM框架整合

### 数据库创建脚本

> 创建一个存放书籍数据的数据库表。

```sql
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
INSERT INTO books(bookID, bookName, bookCounts, details) VALUES (3, 'Linux', 5, '从进门到坐牢');
```

### 基本环境搭建

> 1.新建一个Maven工程，并添加web支持。
>
> 2.导入相关pom依赖。

```xml
<!-- 依赖：Junit、LOG4J、数据库驱动、连接池、Servlet、Jsp、Mybatis、Mybatis-Spring、Spring -->
<dependencies>
  <!--Junit-->
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
  </dependency>
  <!--LOG4J-->
  <dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
  </dependency>
  <!--数据库驱动-->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
  </dependency>
  <!-- 数据库连接池，c3p0 -->
  <dependency>
    <groupId>com.mchange</groupId>
    <artifactId>c3p0</artifactId>
    <version>0.9.5.2</version>
  </dependency>

  <!--Servlet-JSP -->
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
  </dependency>
  <dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>jsp-api</artifactId>
    <version>2.2</version>
  </dependency>
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
  </dependency>

  <!--Mybatis-->
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.2</version>
  </dependency>
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.2</version>
  </dependency>

  <!--Spring-->
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.1.9.RELEASE</version>
  </dependency>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.1.9.RELEASE</version>
  </dependency>
  <dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.5</version>
  </dependency>
</dependencies>
```

> 3.配置Maven资源过滤。

```xml
<!-- 静态资源导出 -->
<build>
  <resources>
    <resource>
      <directory>src/main/java</directory>
      <includes>
        <include>**/*.properties</include>
        <include>**/*.xml</include>
      </includes>
      <filtering>false</filtering>
    </resource>
    <resource>
      <directory>src/main/resources</directory>
      <includes>
        <include>**/*.properties</include>
        <include>**/*.xml</include>
      </includes>
      <filtering>false</filtering>
    </resource>
  </resources>
</build>
```

> 4.建立基本程序结构和配置框架。

- cn.ustb.pojo
- cn.ustb.dao
- cn.ustb.service
- cn.ustb.controller
- mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
</configuration>
```

- applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```

> 5.编写日志配置文件，log4j.properties。

```properties
# 将等级为DEBUG的日志信息输出到console和file两个目的地
log4j.rootLogger=DEBUG,console,file
# 控制台输出的相关设置
log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Target=System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%c]-%m%n
# 文件输出的相关设置
log4j.appender.file=org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/my.log
log4j.appender.file.MaxFileSize=10mb
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=[%p][%d{yyyy-MM-dd}][%c]%m%n
# 日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```

### 编写MyBatis层

> 1.数据库配置文件database.properties。

```properties
jdbc.driver=com.mysql.jdbc.Driver
# MySQL8.0以上的版本，需要增加时区的配置：&serverTimezone=UTC
jdbc.url=jdbc:mysql://localhost:3306/ssmbuild?useSSL=true&useUnicode=true&characterEncoding=utf8
jdbc.username=root
jdbc.password=root123
```

> 2.IDEA关联数据库。
>
> 3.编写MyBatis核心配置文件。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <setting name="logImpl" value="LOG4J"/>
    </settings>
    <!-- 配置数据源，交给Spring去做 -->
    <typeAliases>
        <package name="cn.ustb.pojo"/>
    </typeAliases>
    <mappers>
        <mapper class="cn.ustb.dao.BooksMapper"/>
    </mappers>
</configuration>
```

> 4.在cn.ustb.pojo包中编写数据库对应的实体类Books。

```java
package cn.ustb.pojo;
public class Books {
    private Integer bookID;
    private String bookName;
    private Integer bookCounts;
    private String details;
    public Books() {
    }
    public Books(Integer bookID, String bookName, Integer bookCounts, String details) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookCounts = bookCounts;
        this.details = details;
    }
    public Integer getBookID() {
        return bookID;
    }
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Integer getBookCounts() {
        return bookCounts;
    }
    public void setBookCounts(Integer bookCounts) {
        this.bookCounts = bookCounts;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "Books{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", bookCounts=" + bookCounts +
                ", details='" + details + '\'' +
                '}';
    }
}
```

> 5.在cn.ustb.dao包中编写Dao层的Mapper接口。

```java
package cn.ustb.dao;
import cn.ustb.pojo.Books;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface BooksMapper {
    public boolean addBook(Books vo);
    public boolean updateBook(Books vo);
    public boolean deleteBook(@Param("id") Integer id);
    public Books getBookById(@Param("id") Integer id);
    public List<Books> getAllBooks();
    public List<Books> getBookByName(@Param("bookName") String bookName);
}
```

> 6.编写Dao接口对应的Mapper.xml文件。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.ustb.dao.BooksMapper">
    <insert id="addBook" parameterType="Books">
        INSERT INTO books(bookName,bookCounts,details) VALUES (#{bookName},#{bookCounts},#{details})
    </insert>
    <update id="updateBook" parameterType="Books">
        UPDATE books SET bookName=#{bookName},bookCounts=#{bookCounts},details=#{details}
        WHERE bookID=#{bookID}
    </update>
    <delete id="deleteBook" parameterType="int">
        DELETE FROM books WHERE bookID=#{id}
    </delete>
    <select id="getBookById" parameterType="int" resultType="Books">
        SELECT * FROM books WHERE bookID=#{id}
    </select>
    <select id="getAllBooks" resultType="Books">
        SELECT * FROM books
    </select>
    <select id="getBookByName" resultType="Books">
        SELECT * FROM books WHERE bookName LIKE CONCAT('%',#{bookName},'%')
    </select>
</mapper>
```

> 7.在cn.ustb.service包中编写接口和实现类。

**Service接口**

```java
package cn.ustb.service;
import cn.ustb.pojo.Books;
import java.util.List;
public interface BooksService {
    public boolean addBook(Books vo);
    public boolean updateBook(Books vo);
    public boolean deleteBook(Integer id);
    public Books getBookById(Integer id);
    public List<Books> getAllBooks();
    public List<Books> getBookByName(String bookName);
}
```

**ServiceImpl实现类**

```java
package cn.ustb.service.impl;
import cn.ustb.dao.BooksMapper;
import cn.ustb.pojo.Books;
import cn.ustb.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BooksServiceImpl implements BooksService {
    private BooksMapper booksMapper;
    @Autowired
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }
    public boolean addBook(Books vo) {
        return booksMapper.addBook(vo);
    }
    public boolean updateBook(Books vo) {
        return booksMapper.updateBook(vo);
    }
    public boolean deleteBook(Integer id) {
        return booksMapper.deleteBook(id);
    }
    public Books getBookById(Integer id) {
        return booksMapper.getBookById(id);
    }
    public List<Books> getAllBooks() {
        return booksMapper.getAllBooks();
    }
    public List<Books> getBookByName(String bookName) {
        return booksMapper.getBookByName(bookName);
    }
}
```

### 编写Spring层

> 1.配置Spring整合MyBatis，这里的数据源使用c3p0连接池子。
>
> 2.编写Spring整合MyBatis的相关配置文件，spring-dao.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 1、关联数据库配置文件 -->
    <context:property-placeholder location="classpath:database.properties"/>
    <!-- 2、连接池
        dbcp：半自动化操作，需手动连接
        c3p0：自动化操作（自动化加载配置文件，并且可以自动设置到对象中）
        druid、hikari
     -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <!-- c3p0连接池的私有属性 -->
        <property name="maxPoolSize" value="30"/>
        <property name="minPoolSize" value="10"/>
        <!-- 关闭连接后不自动commit -->
        <property name="autoCommitOnClose" value="false"/>
        <!-- 获取连接超时时间 -->
        <property name="checkoutTimeout" value="10000"/>
        <!-- 当获取连接失败重试次数 -->
        <property name="acquireRetryAttempts" value="2"/>
    </bean>
    <!-- 3、sqlSessionFactory -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!-- 绑定Mybatis的配置文件 -->
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
    </bean>
    <!-- 4、配置dao接口扫描包，动态地实现了dao接口可以注入到Spring容器中 -->
    <!-- 这样就不用在写dao接口实现类了(BooksMapperImpl) -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!-- 1、注入sqlSessionFactory -->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
        <!-- 2、配置要扫描的包 -->
        <property name="basePackage" value="cn.ustb.dao"/>
    </bean>
</beans>
```

> 3.编写Spring整合Service层的相关配置文件，spring-service.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd
       http://www.springframework.org/schema/tx
       https://www.springframework.org/schema/tx/spring-tx.xsd">
    <!-- 1、扫描service包 -->
    <context:component-scan base-package="cn.ustb.service"/>
    <!-- 2、将业务类注入到Spring，可以通过配置或注解实现
        <bean id="BooksServiceImpl" class="cn.ustb.service.impl.BooksServiceImpl">
            <property name="booksMapper" ref="booksMapper"/>
        </bean>
     -->
    <!-- 3、声明式事务配置 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!-- 注入数据源 -->
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!-- 4、AOP事务支持 -->
    <!-- 1、配置事务通知 -->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!-- 给哪些方法配置事务 -->
        <!-- 配置事务的传播特性(propagation)，默认REQUIRED -->
        <tx:attributes>
            <tx:method name="add" propagation="REQUIRED"/>
            <tx:method name="update" propagation="REQUIRED"/>
            <tx:method name="delete" propagation="REQUIRED"/>
            <tx:method name="get" read-only="true"/>
            <tx:method name="query" read-only="true"/>
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>
    <!-- 2、配置事务切入 -->
    <aop:config>
        <aop:pointcut id="txPointCut" expression="execution(* cn.ustb.dao.*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
    </aop:config>
</beans>
```

### 编写Spring MVC层

> 1.编写web.xml配置文件。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <!-- 1、DispatchServlet -->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!-- 2、乱码过滤 -->
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!-- 3、Session过期时间 -->
    <session-config>
        <session-timeout>15</session-timeout>
    </session-config>
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>
```

> 2.编写Spring整合控制层的相关配置文件，spring-mvc.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/mvc
       https://www.springframework.org/schema/mvc/spring-mvc.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd">
    <!-- 1、注解驱动 -->
    <mvc:annotation-driven/>
    <!-- 2、静态资源过滤 -->
    <mvc:default-servlet-handler/>
    <!-- 3、扫描controller -->
    <context:component-scan base-package="cn.ustb.controller"/>
    <!-- 4、视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```

> 3.编写Spring配置整合文件，applicationContext.xml。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <import resource="classpath:spring-dao.xml"/>
    <import resource="classpath:spring-service.xml"/>
    <import resource="classpath:spring-mvc.xml"/>
</beans>
```

### 编写Controller和视图层

> 1.在cn.ustb.controller包中编写控制层操作，BooksController。

```java
package cn.ustb.controller;
import cn.ustb.pojo.Books;
import cn.ustb.service.BooksService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;
    private static Logger logger = Logger.getLogger(BooksController.class);
    /**
     * 查询全部的书籍，并返回书籍展示页面
     * @param model 视图解析器
     * @return 跳转到书籍展示页
     */
    @RequestMapping("/allBooks")
    public String list(Model model) {
        List<Books> allBooks = booksService.getAllBooks();
        logger.info("【书籍列表查询】的结果：" + allBooks);
        model.addAttribute("books", allBooks);
        return "list";
    }
    /**
     * 实现新增前的页面跳转，跳转到新增页面
     * @return 跳转到书籍新增页
     */
    @RequestMapping("/insertPre")
    public String insertPre() {
        return "insert";
    }
    /**
     * 实现新增实际的操作
     * @param books 书籍信息
     * @return 重定向/books/allBooks请求，进入查询书籍列表页
     */
    @RequestMapping("/insertBooks")
    public String insertBooks(Books books) {
        logger.info("insertBooks ==> " + books);
        boolean flag = booksService.addBook(books);
        logger.info("【新增书籍】的结果：" + flag);
        return "redirect:/books/allBooks";
    }
    /**
     * 实现修改前的页面跳转，跳转到修改页面
     * @return 跳转到书籍修改页
     */
    @RequestMapping("/updatePre")
    public String updatePre(int id, Model model) {
        Books books = booksService.getBookById(id);
        model.addAttribute("book", books);
        return "update";
    }
    /**
     * 实现修改实际的操作
     * @param books 书籍信息
     * @return 重定向/books/allBooks请求，进入查询书籍列表页
     */
    @RequestMapping("/updateBooks")
    public String updateBooks(Books books) {
        logger.info("updateBooks ==> " + books);
        boolean flag = booksService.updateBook(books);
        logger.info("【修改书籍】的结果：" + flag);
        return "redirect:/books/allBooks";
    }
    /**
     * 实现删除实际的操作
     * @param id 待删除书籍的ID
     * @return 重定向/books/allBooks请求，进入查询书籍列表页
     */
    @RequestMapping("/deleteBooks/{bookID}")
    public String deleteBooks(@PathVariable("bookID") int id) {
        logger.info("deleteBooks ID ==> " + id);
        boolean flag = booksService.deleteBook(id);
        logger.info("【删除书籍】的结果：" + flag);
        return "redirect:/books/allBooks";
    }
    /**
     * 模糊查询书籍的操作
     * @param bkName 模糊查询的字段
     * @param model 视图解析器
     * @return 跳转到书籍展示页
     */
    @RequestMapping("/searchBooks")
    public String searchBooks(String bkName, Model model) {
        List<Books> books = booksService.getBookByName(bkName);
        if (CollectionUtils.isEmpty(books)) {
            model.addAttribute("error", "未查询到书籍！");
        } else {
            logger.info("searchBooks ==> " + books);
            List<Books> allBooks = new ArrayList<Books>();
            allBooks.addAll(books);
            logger.info("【书籍列表查询】的结果：" + allBooks);
            model.addAttribute("books", allBooks);
        }
        return "list";
    }
}
```

> 2.编写首页，index.jsp。

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SSM框架开发</title>
  <!-- 导入Bootstrap -->
  <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        a {
          text-decoration: none;
          color: black;
          font-size: 18px;
        }
        h3 {
          width:180px;
          height: 38px;
          margin: 100px auto;
          text-align: center;
          line-height: 38px;
          background: deepskyblue;
          border-radius: 5px;
        }
    </style>
</head>
<body>
  <h1 class="text-center">SSM框架整合———书籍管理系统</h1>
  <h3>
      <a href="${pageContext.request.contextPath}/books/allBooks">进入书籍展示页面</a>
  </h3>
</body>
</html>
```

> 3.编写书籍列表展示页面，list.jsp。

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM框架开发</title>
    <!-- 导入Bootstrap -->
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <h1>书籍展示页</h1>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>
                            【书籍列表】 显示所有书籍
                        </small>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 column">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/insertPre">新增书籍</a>
                </div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column">
                    <form class="form-inline" action="${pageContext.request.contextPath}/books/searchBooks" method="post" style="float: right">
                        <span style="color: red;font-weight: bold">${error}</span>
                        <input type="text" name="bkName" class="form-control" placeholder="请输入书籍名称">
                        <input type="submit" class="btn btn-success" value="查询">
                    </form>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>书籍编号</th>
                            <th>书籍名称</th>
                            <th>书籍数量</th>
                            <th>书籍详情</th>
                            <th>操&nbsp;&nbsp;&nbsp;作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.bookID}</td>
                                <td>${book.bookName}</td>
                                <td>${book.bookCounts}</td>
                                <td>${book.details}</td>
                                <td>
                                    <a class="btn btn-info" href="${pageContext.request.contextPath}/books/updatePre?id=${book.bookID}">修改</a>
                                        &nbsp;
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/books/deleteBooks/${book.bookID}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
```

> 4.编写新增书籍页面，insert.jsp。

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM框架开发</title>
    <!-- 导入Bootstrap -->
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <h1>书籍新增页</h1>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>
                            【书籍新增】 请添加书籍信息
                        </small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/books/insertBooks" method="post">
            <div class="form-group">
                <label>书籍名称</label>
                <input type="text" name="bookName" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍详情</label>
                <input type="text" name="details" class="form-control" required>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-success" value="添加">
            </div>
        </form>
    </div>
</body>
</html>
```

> 5.编写更新书籍页面，update.jsp。

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM框架开发</title>
    <!-- 导入Bootstrap -->
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <h1>书籍修改页</h1>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>
                            【书籍修改】 请修改书籍信息
                        </small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/books/updateBooks" method="post">
            <div class="form-group">
                <label>书籍名称</label>
                <input type="text" name="bookName" class="form-control" value="${book.bookName}" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" value="${book.bookCounts}" required>
            </div>
            <div class="form-group">
                <label>书籍详情</label>
                <input type="text" name="details" class="form-control" value="${book.details}" required>
            </div>
            <!-- 前端传递隐藏域 -->
            <input type="hidden" name="bookID" value="${book.bookID}">
            <div class="form-group">
                <input type="submit" class="btn btn-success" value="更新">
            </div>
        </form>
    </div>
</body>
</html>
```

### 运行Tomcat

> 运行Tomcat，测试SSM项目整合情况。