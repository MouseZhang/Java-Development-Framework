package cn.ustb.controller;

import cn.ustb.pojo.Department;
import cn.ustb.pojo.Employee;
import cn.ustb.service.DepartmentService;
import cn.ustb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeService.list();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String insertPre(Model model) {
        // 首先查出部门信息
        List<Department> departments = departmentService.list();
        model.addAttribute("depts", departments);
        return "emp/insert";
    }

    @PostMapping("/emp")
    public String insertEmp(Employee employee) {
        // 新增雇员信息
        employeeService.insert(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String updatePre(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.get(id);
        List<Department> departments = departmentService.list();
        model.addAttribute("emp", employee);
        model.addAttribute("depts", departments);
        return "emp/update";
    }

    @PostMapping("/updateemp")
    public String updateEmp(Employee employee) {
        employeeService.update(employee);
        return "redirect:/emps";
    }

    @GetMapping("/deleteemp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/emps";
    }

}
