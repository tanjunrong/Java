package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {
//    查询所有学生
    List<Student> getStudentList();
//    根据id查询学生
    Student getStudentByID(int id);
//     插入学生
    int insertStudent(Student student);
//    修改学生
    int updateStudent(Student student);
//    删除学生
int deleteStudent(int id);
}
