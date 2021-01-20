package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    @Select("select * from User")
    List<User> getUserByAnnotation();
}
