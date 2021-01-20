package com.dao;

import com.pojo.Student;
import com.pojo.User;
import com.sun.media.sound.SoftJitterCorrector;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DaoTest {

    @Test
    public void queryTest() {
        // 获取SqlSession对象

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

        sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentList();

        for (Student student : studentList) {
            System.out.println(student);
        }

        Student student = studentMapper.getStudentByID(2);
        System.out.println(student);
        sqlSession.close();
    }

    //    增删改需要提交事务!
    @Test
    public void insertTest() {
        // 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        // 执行sql
        int res = studentMapper.insertStudent(new Student(12, 15, " 老赵"));
        if (res > 0) {
            System.out.println("插入成功!");
        } else {
            System.out.println("插入失败!");
        }
        //  提交事务
        sqlSession.commit();
    }

    @Test
    public void updateTest() {
        // 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int res = studentMapper.updateStudent(new Student(12, 18, " 老赵"));
        if (res > 0) {
            System.out.println("更新成功!");
        } else {
            System.out.println("更新失败");
        }

        //  提交事务
        sqlSession.commit();
        sqlSession.close();
    }

        @Test
        public void deleteTest(){
            // 获取SqlSession对象
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            // 执行sql
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int res = studentMapper.deleteStudent(12);
            if (res > 0) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败");
            }

            //  提交事务
            sqlSession.commit();
            sqlSession.close();
        }
}
