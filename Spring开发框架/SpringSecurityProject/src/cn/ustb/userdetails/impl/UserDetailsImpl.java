package cn.ustb.userdetails.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsImpl implements UserDetailsService {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetails loadUserByUsername(final String mid) throws UsernameNotFoundException {
		String sql = "SELECT mid,password,enabled FROM member WHERE mid=?";
		UserDetails details = this.jdbcTemplate.queryForObject(sql, new RowMapper<UserDetails>() {
			@Override
			public UserDetails mapRow(ResultSet rs, int row) throws SQLException {
				// 当查询完数据之后，表示用户名称存在，但是还没有角色
				String sql = "SELECT title FROM role WHERE mid=?";
				// 查询出一个用户所具备的所有角色名称
				List<String> titles = UserDetailsImpl.this.jdbcTemplate.queryForList(sql, String.class, mid);
				// 在Spring安全框架中，必须将角色信息传递给指定的类型，GrantedAuthority用来定义角色信息
				List<GrantedAuthority> allGA = new ArrayList<GrantedAuthority>();
				Iterator<String> iter = titles.iterator();
				while (iter.hasNext()) {
					allGA.add(new SimpleGrantedAuthority(iter.next())); // 实例化认证的标准操作
				}
				// 最后所有的用户数据及权限信息需要保存在UserDetails接口对象中
				return new User(rs.getString(1), rs.getString(2), rs.getInt(3) == 1, true, true, true, allGA);
			}
		}, mid);
		if (details == null) {
			throw new UsernameNotFoundException(mid + "用户，信息不存在！");
		}
		return details;
	}
	
}
