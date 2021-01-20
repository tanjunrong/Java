package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from User")
    List<User> getUserList();
}
