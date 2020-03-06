package cn.ustb.dao;

import cn.ustb.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {

    // 新增雇员数据
    public boolean doCreate(Employee vo);

    // 修改雇员数据
    public boolean doUpdate(Employee vo);

    // 删除雇员数据
    public boolean doRemove(@Param("id") Integer id);

    // 获得所有雇员信息
    public List<Employee> findAll();

    // 通过ID得到雇员
    public Employee findById(@Param("id") Integer id);

}
