package com.mybatis.mapper;

import com.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    //添加用户
    int insertUser();

    //修改用户
    void updateUser();

    //查询全部用户信息
    List<User> getAllUser();
}
