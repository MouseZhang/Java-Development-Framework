package cn.ustb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ustb.dao.DeptMapper;
import cn.ustb.vo.Dept;

@Service
public class DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	public List<Dept> getDepts() {
		List<Dept> depts = deptMapper.selectByExample(null);
		return depts;
	}
}
