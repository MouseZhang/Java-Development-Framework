package cn.ustb.dao.impl;

import cn.ustb.dao.IMemberDAO;
import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class MemberDAOImpl implements IMemberDAO {

	@Override
	public boolean doCreate(Member vo) throws Exception {
		// 如果保存成功则返回当前数据的ID，如果不为空则表示增加成功
		return HibernateSessionFactory.getSession().save(vo) != null;
	}

}
