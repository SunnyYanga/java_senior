package com.yang.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 声明式事务
 *
 *      给方法上标注@Transactional 表示当前方法是一个事务方法
 *      @EnableTransactionManagement 开启基于注解的事务管理功能
 *      配置事务管理器
 *
 * @author yg
 * @date 2020/5/2 15:37
 */
@EnableTransactionManagement
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        return dataSource;
    }
}
