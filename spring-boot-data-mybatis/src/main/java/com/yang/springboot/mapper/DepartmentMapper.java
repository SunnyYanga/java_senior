package com.yang.springboot.mapper;

import com.yang.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * 指定这是一个操作数据库的mapper
 * @author yg
 * @date 2020/5/7 17:57
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
