package com.yang.springbootcache.mapper;

import com.yang.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author yg
 * @date 2020/6/4 10:10
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Update("update employee set lastName = #{lastName}, email = #{email}, gender = #{gender} where id = #{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteEmp(Integer id);

    @Insert("insert into employee(lastName, email, gender, d_id) values(#{lastName, #{email}, #{gender}, #{dId}) ")
    void insertEmp(Employee employee);
}
