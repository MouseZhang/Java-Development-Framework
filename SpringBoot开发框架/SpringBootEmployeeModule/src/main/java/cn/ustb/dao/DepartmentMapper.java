package cn.ustb.dao;


import cn.ustb.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentMapper {

    // 获得所有部门信息
    public List<Department> findAll();

    // 通过ID得到部门
    public Department findById(@Param("id") Integer id);

}
