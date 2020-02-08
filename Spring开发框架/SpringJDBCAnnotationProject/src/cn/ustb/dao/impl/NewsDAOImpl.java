package cn.ustb.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cn.ustb.dao.INewsDAO;
import cn.ustb.vo.News;

@Component
public class NewsDAOImpl implements INewsDAO {
	private JdbcTemplate jt;
	
	@Autowired // 自动根据匹配类型注入所需要的数据
	public NewsDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public boolean doCreate(News vo) throws Exception {
		String sql = "INSERT INTO news(title,pubdate,content) VALUES(?,?,?)";
		int count = jt.update(sql, vo.getTitle(), vo.getPubdate(), vo.getContent());
		return count > 0;
	}

}
