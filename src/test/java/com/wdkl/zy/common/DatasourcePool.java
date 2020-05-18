package com.wdkl.zy.common;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourcePool {

    private List<MpConfig> configs;

    @Data
    public static class MpConfig {

        // 数据库驱动
        private String driverClassName;

        // 数据库地址
        private String jdbcUrl;

        // 用户名
        private String username;

        // 密码
        private String password;

        //
        private String type;


    }



//    // 数据库驱动
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    // 数据库地址
//    @Value("${spring.datasource.url}")
//    private String jdbcUrl;
//
//    // 用户名
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    // 密码
//    @Value("${spring.datasource.password}")
//    private String password;
//
//
//
//
//    @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setJdbcUrl(jdbcUrl);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//
//        return dataSource;
//    }



}
