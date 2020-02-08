package cn.ustb.demo;

import java.sql.Connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemoA {
	public static void main(String[] args) throws Exception {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("org.gjt.mm.mysql.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/springdb?characterEncoding=utf8");
		source.setUsername("root");
		source.setPassword("root123");
		Connection conn = source.getConnection();
		System.out.println(conn);
	}
}
