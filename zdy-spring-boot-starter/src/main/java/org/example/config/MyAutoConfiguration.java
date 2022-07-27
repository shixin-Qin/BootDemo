package org.example.config;

import org.example.aspects.RefreshCacheAspect;
import org.example.pojo.SimpleBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass
public class MyAutoConfiguration {

    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

    @Bean
    public RefreshCacheAspect refreshCacheAspect(){
        return new RefreshCacheAspect();
    }
}
