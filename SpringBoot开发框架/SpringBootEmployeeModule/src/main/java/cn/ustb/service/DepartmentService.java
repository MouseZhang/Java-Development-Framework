package cn.ustb.service;

import cn.ustb.pojo.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> list();

    public Department get(Integer id);

}
