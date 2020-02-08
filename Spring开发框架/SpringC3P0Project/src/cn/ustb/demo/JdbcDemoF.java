package cn.ustb.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDemoF {
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
		String sql = "SELECT COUNT(*) FROM news WHERE title LIKE ? LIMIT ?,?";
		// 数据量统计
		Integer count = jt.queryForObject(sql, new Object[] {"%%", 0, 2}, Integer.class);
		System.out.println(count);
		source.getConnection().close();
	}
}
