package com.yang.dao;

import com.mysql.cj.x.protobuf.MysqlxCursor;
import com.yang.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author yg
 * @date 2020/4/22 18:01
 */
public interface IAccountDao {
    /**
     * 查询所有账户，并且获取每个账户所属用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap", value={
            @Result(id=true,column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "uid", one=@One(select="com.yang.dao.findById", fetchType= FetchType.EAGER)),
    })
    List<Account> findAll();

    @Select("select * from account where uid=#{id}")
    List<Account> findAccountByUid(Integer uid);
}
