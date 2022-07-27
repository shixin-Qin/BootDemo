package com.example.zdy_demo.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(){
        //Redisson需要的配置
        Config config = new Config();
        String node = "127.0.0.1:6379";//redis地址
        node = node.startsWith("redis://") ? node : "redis://" + node;
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(node)
                .setTimeout(3000)//超时时间
                .setConnectionPoolSize(10)
                .setConnectionMinimumIdleSize(10);
        //serverConfig.setPassword("123456");//设置redis密码
        // 创建RedissonClient客户端实例
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
