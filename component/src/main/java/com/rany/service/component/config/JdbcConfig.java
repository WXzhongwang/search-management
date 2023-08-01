package com.rany.service.component.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author zhongshengwang
 */
@Configuration
public class JdbcConfig {

    @Bean
    @ConditionalOnProperty(prefix = "metastore", value = "type", havingValue = "mysql")
    public DataSource dataSource(MySQLMetaStoreProperty property) {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUrl(property.getJdbcUrl());
        mysqlDataSource.setUser(property.getUsername());
        mysqlDataSource.setPassword(property.getPassword());
        return mysqlDataSource;
    }

    @Bean
    @ConditionalOnBean(value = DataSource.class)
    public JdbcTemplate jdbcTemplate(MySQLMetaStoreProperty property) {
        return new JdbcTemplate(dataSource(property));
    }
}
