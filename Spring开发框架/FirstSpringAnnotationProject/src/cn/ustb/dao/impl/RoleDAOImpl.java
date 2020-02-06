package cn.ustb.dao.impl;

import org.springframework.stereotype.Component;

import cn.ustb.dao.IRoleDAO;

@Component
public class RoleDAOImpl implements IRoleDAO {

	@Override
	public boolean findAll() {
		System.out.println("【IRoleDAO】 public boolean findAll()");
		return true;
	}

}
