package cn.ustb.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cn.ustb.dao.INewsDAO;
import cn.ustb.pojo.News;

@Component
public class NewsDAOImpl extends HibernateDaoSupport implements INewsDAO {
	
	@Autowired
	public NewsDAOImpl(HibernateTemplate ht) {
		super.setHibernateTemplate(ht);
	}
	
	@Override
	public boolean doCreate(News vo) throws Exception {
		return super.getHibernateTemplate().save(vo) != null;
	}

	@Override
	public boolean doUpdate(News vo) throws Exception {
		String hql = "UPDATE News SET title=?,pubdate=?,content=? WHERE nid=?";
		Query query = super.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
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
		Query query = super.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(buf.toString());
		return query.executeUpdate() > 0;
	}
	
	@Override
	public News findById(Integer id) throws Exception {
		return super.getHibernateTemplate().get(News.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List findAll() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(News.class);
		return super.getHibernateTemplate().findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(News.class);
		dc.add(Restrictions.like(column, "%" + keyWord + "%"));
		return super.getHibernateTemplate().findByCriteria(dc, (currentPage - 1) * lineSize, lineSize);
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String hql = "SELECT COUNT(*) FROM News AS n WHERE n." + column + " LIKE ?";
		Long count = (Long) super.getHibernateTemplate().find(hql, "%" + keyWord + "%").get(0);
		return count.intValue();
	}

}
