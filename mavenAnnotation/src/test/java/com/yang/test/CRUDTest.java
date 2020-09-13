package com.yang.test;

import com.yang.dao.IUserDao;
import com.yang.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author yg
 * @date 2020/4/22 16:57
 */
public class CRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao dao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        dao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("ss");
        user.setAddress("ssssssssss");
        user.setBirthday(new Date());
        user.setSex("male");
        dao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setUsername("ss");
        user.setAddress("ssssssssss");
        user.setBirthday(new Date());
        user.setSex("male");
        dao.updateUser(user);
    }

    @Test
    public void testDelete(){
        dao.deleteUser(1);
    }

    @Test
    public void testFind1(){
        User user = dao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> user = dao.findUserByName("%Tom%");
        user.forEach(System.out::println);
    }

    @Test
    public void testFingTotal(){
        Integer i = dao.findTotal();
        System.out.println(i);
    }

}
