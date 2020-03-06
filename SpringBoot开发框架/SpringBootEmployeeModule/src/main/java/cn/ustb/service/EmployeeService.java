package cn.ustb.service;

import cn.ustb.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    public boolean insert(Employee vo);

    public boolean update(Employee vo);

    public boolean delete(Integer id);

    public List<Employee> list();

    public Employee get(Integer id);
}
