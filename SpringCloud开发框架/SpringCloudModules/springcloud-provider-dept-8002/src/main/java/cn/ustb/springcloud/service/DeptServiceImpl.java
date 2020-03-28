package cn.ustb.springcloud.service;

import cn.ustb.springcloud.dao.DeptDao;
import cn.ustb.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    @Override
    public boolean insertDept(Dept dept) {
        return deptDao.insertDept(dept);
    }

    @Override
    public Dept getDeptById(Long id) {
        return deptDao.getDeptById(id);
    }

    @Override
    public List<Dept> listDepts() {
        return deptDao.listDepts();
    }

}
