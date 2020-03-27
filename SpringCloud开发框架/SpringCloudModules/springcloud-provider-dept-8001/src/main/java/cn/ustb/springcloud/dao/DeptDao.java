package cn.ustb.springcloud.dao;

import cn.ustb.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean insertDept(Dept dept);

    public Dept getDeptById(@Param("id") Long id);

    public List<Dept> listDepts();

}
