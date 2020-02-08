package cn.ustb.demo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemoE {
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
		String sql = "SELECT title FROM news WHERE title LIKE ? LIMIT ?,?";
		// queryForList只能返回单列数据，不能自动进行vo类的转换
		List<String> all = jt.queryForList(sql, new Object[] {"%%", 0, 2}, String.class);
		System.out.println(all);
		source.getConnection().close();
	}
}
