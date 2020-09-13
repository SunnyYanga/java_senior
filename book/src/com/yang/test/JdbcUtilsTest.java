package com.yang.test;

import com.yang.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author yg
 * @date 2020/4/7 17:02
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }

    }
}
