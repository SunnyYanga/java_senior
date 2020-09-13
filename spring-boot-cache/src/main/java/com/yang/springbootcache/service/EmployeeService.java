package com.yang.springbootcache.service;

import com.yang.springbootcache.bean.Employee;
import com.yang.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author yg
 * @date 2020/6/4 10:21
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp", key = "#id")
    public Employee getEmpById(Integer id){
        System.out.println("查询"+ id);
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

}
