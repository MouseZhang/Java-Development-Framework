package cn.ustb.springcloud.service;

import cn.ustb.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean insertDept(Dept dept);

    public Dept getDeptById(Long id);

    public List<Dept> listDepts();
}
