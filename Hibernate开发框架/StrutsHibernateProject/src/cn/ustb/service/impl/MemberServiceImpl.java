package cn.ustb.service.impl;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.factory.DAOFactory;
import cn.ustb.pojo.Member;
import cn.ustb.service.IMemberService;

public class MemberServiceImpl implements IMemberService {

	@Override
	public boolean insert(Member vo) throws Exception {
		try {
			boolean flag = DAOFactory.getIMemberDAOInstance().doCreate(vo);
			HibernateSessionFactory.getSession().beginTransaction().commit();
			return flag;
		} catch (Exception e) {
			throw e;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
