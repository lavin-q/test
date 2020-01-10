package com.qhm.example.test.springBoot_elasticJob;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ Description:  zookeeper注册中心配置类
 * @ Author: qhm
 * @ Date: 2020/1/10 9:58
 * @ Version: 1.0
 */
@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length() > 0")
@PropertySource({"classpath:application.properties"})
public class RegistryCenterConfig {

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter registryCenter(@Value("${regCenter.serverList}")final String serverList,@Value("${regCenter.namespace}")final String namespace){
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList,namespace));
    }
}
