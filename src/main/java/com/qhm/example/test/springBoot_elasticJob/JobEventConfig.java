package com.qhm.example.test.springBoot_elasticJob;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Description:定时器时事件数据源配置
 * @ Author: qhm
 * @ Date: 2020/1/10 10:13
 * @ Version: 1.0
 */
@Configuration
public class JobEventConfig {
    @Bean
    public JobEventConfiguration jobEventConfiguration(@Value("${jobEventConfig.url}") final String url, @Value("${jobEventConfig.driverClassName}") final String driverClassName,
                                                       @Value("${jobEventConfig.username}") final String username, @Value("${jobEventConfig.password}") final String password){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        //dataSource.setPassword(EncryptUtils.decrypt(password));
        return new JobEventRdbConfiguration(dataSource);
    }

}
