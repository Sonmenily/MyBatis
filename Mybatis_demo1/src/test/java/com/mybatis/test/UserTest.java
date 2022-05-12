package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    @Test
    public void test01() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        //获取SqlSession工厂构建对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过工厂构建对象传入核心配置文件获取SqlSession工厂
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //通过工厂对象获取sqlSession对象（工厂模式）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //Mapper接口不提供实现类，sqlSession.getMapper()方法利用代理模式创建Mapper的实现类对象（代理模式）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //执行操作
        int result = userMapper.insertUser();
        //事务提交（若不提交事务，则无效果）
        sqlSession.commit();
        //打印输出
        System.out.println("result:"+result);
    }

    @Test
    public void test02() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        UserMapper mapper = new SqlSessionFactoryBuilder().build(is).openSession(true).getMapper(UserMapper.class);
        mapper.updateUser();
    }

    @Test
    public void test03() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        UserMapper mapper = new SqlSessionFactoryBuilder().build(is).openSession(true).getMapper(UserMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user.toString()));
    }
}
