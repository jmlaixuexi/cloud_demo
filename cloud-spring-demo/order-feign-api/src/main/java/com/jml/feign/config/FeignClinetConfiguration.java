package com.jml.feign.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 自定义Feign配置
 * 1、启动全局配置@EnableFeignClients(defaultConfiguration = FeignClinetConfiguration.class)
 * 2、启动局部配置@FeignClient(value = "user-server",configuration = FeignClinetConfiguration.class)
 */
public class FeignClinetConfiguration {

    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC;
    }
}
