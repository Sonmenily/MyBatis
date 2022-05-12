package com.mybatis.mappers;

import com.mybatis.pojo.Emp;

import java.util.List;

public interface EmpMapper {

    //获取全部员工信息
    List<Emp> getAllEmp();
}
