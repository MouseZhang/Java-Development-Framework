package cn.ustb.dao;

import cn.ustb.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("SELECT * FROM teacher WHERE tid=#{tid}")
    public Teacher getTeacherById(@Param("tid") Integer tid);

}
