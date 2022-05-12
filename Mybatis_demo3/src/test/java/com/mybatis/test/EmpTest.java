package com.mybatis.test;

import com.mybatis.mappers.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.junit.Test;

import java.util.List;

public class EmpTest {
    @Test
    public void test01(){
        EmpMapper empMapper = SqlSessionUtils.getSqlSession("mybatis-config.xml").getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmp();
        empList.forEach(emp -> System.out.println(emp));
    }
}
