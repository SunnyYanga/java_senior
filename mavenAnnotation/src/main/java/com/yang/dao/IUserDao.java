package com.yang.dao;

import com.yang.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author yg
 * @date 2020/4/19 17:15
 * @Select, @Insert, @Update, @Delete
 */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from t_user")
    @Results(id= "userMap", value={
            @Result(id=true,column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address", property = "address"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id" , many=@Many(select = "com.yang.dao.IAccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Insert("insert into t_user(username, address, sex, birthday) values (#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    @Update("update t_user set username = #{username}, sex = #{sex} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from t_user where id= #{id}")
    void deleteUser(Integer userId);

    @Select("select * from t_user where id = #{id}")
    @ResultMap(value={"userMap"})
    User findById(Integer userId);

    @Select("select * from t_user where username like #{username}")
    List<User> findUserByName(String username);


    @Select("select count(*) from t_user")
    int findTotal();
}
