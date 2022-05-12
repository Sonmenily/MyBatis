package com.mybatis.test;

import com.mybatis.mappers.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    @Test
    public void test01() throws IOException {
        UserMapper mapper = SqlSessionUtils.getSqlSession("mybatis-config.xml").getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user.toString()));
    }

    @Test
    public void test02() throws IOException {
        UserMapper mapper = SqlSessionUtils.getSqlSession("mybatis-config.xml").getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void test03() throws IOException {
        UserMapper mapper = SqlSessionUtils.getSqlSession("mybatis-config.xml").getMapper(UserMapper.class);
        User user = mapper.checkedLogin("admin","admin");
        System.out.println(user);
    }

    @Test
    public void test04() throws IOException {
        UserMapper mapper = SqlSessionUtils.getSqlSession("mybatis-config.xml").getMapper(UserMapper.class);
        int result = mapper.insertUser(new User(null,"测试数据1","测试数据1",18,"男","测试数据1"));
        System.out.println(result);
    }
}
