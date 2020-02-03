package cn.ustb.factory;

import cn.ustb.dao.IMemberDAO;
import cn.ustb.dao.impl.MemberDAOImpl;

public class DAOFactory {
	public static IMemberDAO getIMemberDAOInstance() {
		return new MemberDAOImpl();
	}
}
