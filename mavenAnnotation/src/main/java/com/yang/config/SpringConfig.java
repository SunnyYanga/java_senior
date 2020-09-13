package com.yang.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;
import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @author yg
 * @date 2020/4/24 15:57
 * Bean 用于把当前方法返回值作为bean对象存入spring的ioc容器中
 *      属性name 用于指定bean的id
 */
@Configuration
@ComponentScan(basePackages = "com.yang")
@PropertySource("classpath:")
public class SpringConfig {
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "datasource")
    public DataSource createDataSource(){
        try {
            DataSource ds = new ComboPooledDataSource();
//            ds.setDriverClass("");
//            ds.setJdbcUrl("");
//            ds.setUser("");
//            ds.setPassword("");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
