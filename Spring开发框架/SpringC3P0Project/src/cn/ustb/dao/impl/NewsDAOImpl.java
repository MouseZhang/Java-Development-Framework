package cn.ustb.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import cn.ustb.dao.INewsDAO;
import cn.ustb.vo.News;

@Component
public class NewsDAOImpl extends JdbcDaoSupport implements INewsDAO {
	@Autowired // 自动根据匹配类型注入所需要的数据
	public NewsDAOImpl(JdbcTemplate jt) {
		super.setJdbcTemplate(jt);
	}

	@Override
	public boolean doCreate(News vo) throws Exception {
		String sql = "INSERT INTO news(title,pubdate,content) VALUES(?,?,?)";
		// 只有通过super.getJdbcTemplate()方法才能正常关闭数据库
		int count = super.getJdbcTemplate().update(sql, vo.getTitle(), vo.getPubdate(), vo.getContent());
		return count > 0;
	}

}
