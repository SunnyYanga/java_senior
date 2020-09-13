package com.yang.springboot.mapper;

import com.yang.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yg
 * @date 2020/5/7 18:15
 */
@Mapper
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
