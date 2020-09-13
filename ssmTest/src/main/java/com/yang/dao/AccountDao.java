package com.yang.dao;

import com.yang.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yg
 * @date 2020/4/30 9:06
 */
@Repository
public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account(name, money) values (#{name}, #{money})")
    void saveAccount(Account account);
}
