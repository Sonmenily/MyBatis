package com.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import com.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.util.List;

public class MGBTest {
    @Test
    public void test01(){
        EmpMapper mapper = SqlSessionUtils.getSqlSession("mybatis-config.xml").getMapper(EmpMapper.class);
        EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("张三");
        for (Emp emp : mapper.selectByExample(example)) {
            System.out.println(emp);
        }
    }
    @Test
    public void test02(){
        PageHelper.startPage(1,2);
        EmpMapper mapper = SqlSessionUtils.getSqlSession("mybatis-config.xml").getMapper(EmpMapper.class);
        List<Emp> empList = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(empList,2);
        System.out.println(pageInfo);
    }
}
