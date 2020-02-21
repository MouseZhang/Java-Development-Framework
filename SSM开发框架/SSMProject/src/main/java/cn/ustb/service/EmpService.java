package cn.ustb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ustb.dao.EmpMapper;
import cn.ustb.vo.Emp;
import cn.ustb.vo.EmpExample;
import cn.ustb.vo.EmpExample.Criteria;

@Service
public class EmpService {

	@Autowired
	EmpMapper empMapper;
	
	public List<Emp> getAll() {
		EmpExample example = new EmpExample();
		example.setOrderByClause("empno");
		return empMapper.selectByExampleWithDept(example);
	}
	
	public void insert(Emp vo) {
		empMapper.insertSelective(vo);
	}

	public boolean checkName(String ename) {
		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnameEqualTo(ename);
		long count = empMapper.countByExample(example);
		return count == 0;
	}

	public Emp getEmp(Integer id) {
		Emp emp = empMapper.selectByPrimaryKey(id);
		return emp;
	}

	public void updateEmp(Emp vo) {
		empMapper.updateByPrimaryKeySelective(vo);
	}

	public void doRemoveBatch(List<Integer>  ids) {
		EmpExample example = new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpnoIn(ids);
		empMapper.deleteByExample(example);
	}
	
}
