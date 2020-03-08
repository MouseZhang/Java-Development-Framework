package cn.ustb.dao;

import cn.ustb.pojo.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> getStudents();

    public List<Student> getStudentsTeach();

}
