package cn.ustb.dao;


import cn.ustb.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    public List<Teacher> getTeachers();

    public Teacher getTeacherById(@Param("tid") Integer tid);

    public Teacher getTeacherStuById(@Param("tid") Integer tid);
}
