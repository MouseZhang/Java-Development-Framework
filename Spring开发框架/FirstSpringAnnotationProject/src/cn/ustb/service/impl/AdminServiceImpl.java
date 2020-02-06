package cn.ustb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ustb.dao.IAdminDAO;
import cn.ustb.dao.IRoleDAO;
import cn.ustb.service.IAdminService;

/**
 * 此时的Service层AdminServiceImpl的引用名称是：adminServiceImpl
 * Service层的@Resource注解(表示此为注入的资源)就等价于：
 * 	<property name="adminDAO" ref="adminDAOImpl" />
 *  <property name="roleDAO" ref="roleDAOImpl" />
 * @author MouseZhang
 *
 */

@Service
public class AdminServiceImpl implements IAdminService {
	@Resource
	private IAdminDAO adminDAO;
	@Resource
	private IRoleDAO roleDAO;

//	setter方法注解
//	private IAdminDAO adminDAO;
//	@Resource(name="adminDAOImpl")
//	public void setAdminDAO(IAdminDAO adminDAO) {
//		this.adminDAO = adminDAO;
//	}
	
	@Override
	public boolean login() {
		this.adminDAO.findLogin();
		this.roleDAO.findAll();
		return true;
	}

}
