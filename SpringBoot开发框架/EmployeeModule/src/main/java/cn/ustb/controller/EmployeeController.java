package cn.ustb.controller;

import cn.ustb.dao.DepartmentDao;
import cn.ustb.dao.EmployeeDao;
import cn.ustb.pojo.Department;
import cn.ustb.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String insertPre(Model model) {
        // 首先查出部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/insert";
    }

    @PostMapping("/emp")
    public String insertEmp(Employee employee) {
        // 新增雇员信息
        employeeDao.insert(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String updatePre(@PathVariable("id") int id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", employee);
        model.addAttribute("depts", departments);
        return "emp/update";
    }

    @PostMapping("/updateemp")
    public String updateEmp(Employee employee) {
        employeeDao.insert(employee);
        return "redirect:/emps";
    }

    @GetMapping("/deleteemp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
