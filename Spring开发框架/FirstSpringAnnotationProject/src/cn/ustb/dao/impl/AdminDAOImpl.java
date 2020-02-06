package cn.ustb.dao.impl;

import org.springframework.stereotype.Component;

import cn.ustb.dao.IAdminDAO;

/**
 * Annotation注解分为3个，作用都相同：
 * <li>@Component：主要用于定义组件，一般都在DAO上使用</li>
 * <li>@Service：主要用于定义组件，一般都在Service上使用</li>
 * <li>@Repository：主要用于定义组件，一般都在Action上使用</li>
 * 现在如果使用注解定义组件，那么名称默认情况下是类名称的结构形式：
 * 例如，AdminDAOImpl，则访问组件的名称就是：adminDAOImpl
 * @author MouseZhang
 *
 */

@Component
public class AdminDAOImpl implements IAdminDAO {

	@Override
	public boolean findLogin() {
		System.out.println("【IAdminDAO】 public boolean findLogin()");
		return true;
	}

}
