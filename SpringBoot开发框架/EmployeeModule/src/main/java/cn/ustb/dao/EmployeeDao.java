package cn.ustb.dao;

import cn.ustb.pojo.Department;
import cn.ustb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao; // 雇员所属部门

    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    static {
        employees = new HashMap<>(); // 创建一个雇员表
        employees.put(1001, new Employee(1001, "SMITH", "smith@163.com", 1, new Department(101, "开发部")));
        employees.put(1002, new Employee(1002, "JONE", "jone@126.com", 0, new Department(102, "运营部")));
        employees.put(1003, new Employee(1003, "ALLEN", "allen@qq.com", 0, new Department(103, "维护部")));
        employees.put(1004, new Employee(1004, "KING", "king@gmail.com", 1, new Department(104, "数据部")));
        employees.put(1005, new Employee(1005, "LEE", "lee@163.com", 1, new Department(105, "人力部")));
    }

    // 主键自增
    private static Integer initId = 1006;

    public void insert(Employee employee) {
        if (employee.getEmpno() == null) {
            employee.setEmpno(initId++);
        }
        employee.setDept(departmentDao.getDepartmentById(employee.getDept().getDeptno())); // 部门外键关联
        employees.put(employee.getEmpno(), employee);
    }

    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }

}
