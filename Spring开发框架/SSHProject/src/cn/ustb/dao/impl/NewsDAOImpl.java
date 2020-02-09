package cn.ustb.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import cn.ustb.dao.INewsDAO;
import cn.ustb.pojo.News;

@Component
public class NewsDAOImpl implements INewsDAO {
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public boolean doCreate(News vo) throws Exception {
		return sessionFactory.getCurrentSession().save(vo) != null;
	}

	@Override
	public boolean doUpdate(News vo) throws Exception {
		String hql = "UPDATE News SET title=?,pubdate=?,content=? WHERE nid=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, vo.getTitle());
		query.setParameter(1, vo.getPubdate());
		query.setParameter(2, vo.getContent());
		query.setParameter(3, vo.getNid());
		return query.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM News WHERE nid IN (");
		Iterator<Integer> iter = ids.iterator();
		while (iter.hasNext()) {
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length() - 1, buf.length()).append(")");
		Query query = this.sessionFactory.getCurrentSession().createQuery(buf.toString());
		return query.executeUpdate() > 0;
	}
	
	@Override
	public News findById(Integer id) throws Exception {
		return (News) this.sessionFactory.getCurrentSession().get(News.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> findAll() throws Exception {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(News.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		String hql = "FROM News AS n WHERE n." + column + " LIKE ?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, "%" + keyWord + "%");
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		return query.list();
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String hql = "SELECT COUNT(*) FROM News AS n WHERE n." + column + " LIKE ?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, "%" + keyWord + "%");
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}

}
