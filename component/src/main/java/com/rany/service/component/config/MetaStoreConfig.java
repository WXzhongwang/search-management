package com.rany.service.component.config;

import com.rany.service.component.IMetaStorage;
import com.rany.service.component.MetaStoreEnum;
import com.rany.service.component.store.MySQLStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2022/4/2 11:42 下午
 * @email 18668485565@163.com
 */
@Configuration
public class MetaStoreConfig {

    @Value("${metastore.type}")
    private MetaStoreEnum metaStoreType;
    @Value("${metastore.env}")
    private String metaStoreEnv;

    private IMetaStorage metaStorage;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MetaStoreEnum getMetaStoreType() {
        return metaStoreType;
    }

    public String getMetaStoreEnv() {
        return metaStoreEnv;
    }

    @Bean
    @ConfigurationProperties(prefix = "metastore.ots")
    @ConditionalOnProperty(prefix = "metastore", value = "type", havingValue = "ots")
    public OtsMetaStoreProperty otsConfig() {
        return new OtsMetaStoreProperty();
    }

    @Bean
    @ConfigurationProperties(prefix = "metastore.mysql")
    @ConditionalOnProperty(prefix = "metastore", value = "type", havingValue = "mysql")
    public MySQLMetaStoreProperty mysqlConfig() {
        return new MySQLMetaStoreProperty();
    }

    public IMetaStorage getMetaStorage() {
        return metaStorage;
    }

    public String dumpConfigString() {
        switch (metaStoreType) {
            case OTS:
                OtsMetaStoreProperty otsConfig = otsConfig();

                return String.format(
                        "Type=OTS;Env=%s;InstanceEndpoint=%s;AkId=%s;AkSecret=%s;InstanceName=%s",
                        metaStoreEnv, otsConfig.getEndpoint(), otsConfig.getAk(),
                        otsConfig.getSk(), otsConfig.getInstance());
            case MYSQL:
                MySQLMetaStoreProperty mySQLProperty = mysqlConfig();
                metaStorage = new MySQLStore(jdbcTemplate, metaStoreEnv);
                return String.format(
                        "Type=MYSQL;Env=%s;MysqlUrl=%s;UserName=%s;DatabaseName=%s",
                        metaStoreEnv, mySQLProperty.getJdbcUrl(), mySQLProperty.getUsername(), mySQLProperty.getDatabase());
        }
        return "InvalidMetaStoreType";
    }
}
