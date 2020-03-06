package cn.ustb.service.impl;

import cn.ustb.dao.EmployeeMapper;
import cn.ustb.pojo.Employee;
import cn.ustb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public boolean insert(Employee vo) {
        return employeeMapper.doCreate(vo);
    }

    @Override
    public boolean update(Employee vo) {
        return employeeMapper.doUpdate(vo);
    }

    @Override
    public boolean delete(Integer id) {
        return employeeMapper.doRemove(id);
    }

    @Override
    public List<Employee> list() {
        return employeeMapper.findAll();
    }

    @Override
    public Employee get(Integer id) {
        return employeeMapper.findById(id);
    }

}
