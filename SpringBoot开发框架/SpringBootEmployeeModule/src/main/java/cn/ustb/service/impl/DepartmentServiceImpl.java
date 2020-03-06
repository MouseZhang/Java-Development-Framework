package cn.ustb.service.impl;

import cn.ustb.dao.DepartmentMapper;
import cn.ustb.pojo.Department;
import cn.ustb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> list() {
        return departmentMapper.findAll();
    }

    @Override
    public Department get(Integer id) {
        return departmentMapper.findById(id);
    }

}
