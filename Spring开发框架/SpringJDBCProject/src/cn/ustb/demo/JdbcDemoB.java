package cn.ustb.demo;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemoB {
	public static void main(String[] args) throws Exception {
		// 1、数据库的连接必须首先处理
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("org.gjt.mm.mysql.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/springdb?characterEncoding=utf8");
		source.setUsername("root");
		source.setPassword("root123");
		// 2、处理JDBC的相关操作
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(source);
		String sql = "INSERT INTO news(title,pubdate,content) VALUES(?,?,?)";
		int count = jt.update(sql, "新闻标题", new Date(), "新闻内容");
		System.out.println("更新数据行数：" + count);
		source.getConnection().close();
	}
}
