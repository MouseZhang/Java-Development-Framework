package cn.ustb.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import cn.ustb.vo.News;

public class JdbcDemoD {
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
		String sql = "SELECT nid,title,pubdate,content FROM news WHERE title LIKE ? LIMIT ?,?";
		List<News> all = jt.query(sql, new RowMapper<News>() {
			@Override
			public News mapRow(ResultSet rs, int rowCount) throws SQLException {
				System.out.println("返回当前的数据行：" + rowCount);
				News vo = new News();
				vo.setNid(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPubdate(rs.getDate(3));
				vo.setContent(rs.getString(4));
				return vo;
			}
			
		}, "%%", 0, 2);
		System.out.println(all);
		source.getConnection().close();
	}
}
