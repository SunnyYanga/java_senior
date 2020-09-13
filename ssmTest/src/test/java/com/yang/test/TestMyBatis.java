package com.yang.test;

import com.yang.dao.AccountDao;
import com.yang.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author yg
 * @date 2020/4/30 10:57
 */
public class TestMyBatis {

    @Test
    public void run1() throws Exception {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = factory.openSession();
        // 获取代理对象
        AccountDao accountDao = session.getMapper(AccountDao.class);
//        List<Account> accounts = accountDao.findAll();
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        Account account = new Account();
        account.setName("Tom");
        account.setMoney(3000d);
        accountDao.saveAccount(account);
        session.commit();
        session.close();
        stream.close();
    }
}
