package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMap {
//    @Select("SELECT id,username,age,phone,email FROM USERS WHERE AGE=#{age}")
//    List<User> getUser(int age);

    @Select("SELECT id,username,age,phone,email FROM USERS WHERE email = #{email}")
    User getUser(String email);

    @Select("SELECT * FROM USERS WHERE email = #{email}")
    User login(String email);

    @Insert("INSERT INTO USERS(email, password) VALUES(#{email}, #{password})")
    int register(User user);

    @Select("SELECT * FROM USERS")
    List<User> getUserList();

}

