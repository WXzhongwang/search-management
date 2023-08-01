package com.rany.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 管理平台Server
 *
 * @author zhongshengwang
 * @description 管理平台
 * @date 2021/7/30 9:02 下午
 * @email 18668485565@163.com
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MasterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterServiceApplication.class, args);
    }
}
