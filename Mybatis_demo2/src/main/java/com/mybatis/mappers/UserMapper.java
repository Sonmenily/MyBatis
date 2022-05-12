package com.mybatis.mappers;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //添加用户
    int insertUser(User user);

    //修改用户
    void updateUser();

    //查询全部用户信息
    List<User> getAllUser();

    //根据用户id查询用户信息
    User getUserById(Integer id);

    //根据用户名和密码验证登录
    User checkedLogin(@Param(value = "username")String username, @Param(value = "password")String password);

}
