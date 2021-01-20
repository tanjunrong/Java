package dao;

import com.dao.StudentMapper;
import com.dao.UserMapper;
import com.pojo.Student;
import com.pojo.User;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class DaoTest {

    static Logger logger = Logger.getLogger(DaoTest.class);

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

    @Test
    public void getUserByAnnotationTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getUserByAnnotation();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getByLimitTest(){
        // 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        // 执行sql
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("startIndex",0);
        hashMap.put("pageSize",2);
        List<Student> studentList = studentMapper.getStudentListByLimit(hashMap);
        for (Student student : studentList) {
            System.out.println(student);
        }
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
    public void deleteTest() {
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


    @Test
    public void testLOG4J() {
        logger.info("info:进入testLOG4J");
        logger.debug("debug:进入testLOG4J");
        logger.error("error:进入testLOG4J");
    }
}
