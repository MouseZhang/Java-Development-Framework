package cn.ustb.dao;

import cn.ustb.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    // 模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<>(); // 创建一个部门表
        departments.put(101, new Department(101, "开发部"));
        departments.put(102, new Department(102, "运营部"));
        departments.put(103, new Department(103, "维护部"));
        departments.put(104, new Department(104, "数据部"));
        departments.put(105, new Department(105, "人力部"));
    }

    // 获得所有部门信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    // 通过ID得到部门
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

}
