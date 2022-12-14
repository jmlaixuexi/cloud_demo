package com.jml.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderRibboApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderRibboApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    //全局配置
//    @Bean
//    public IRule randomRule(){
//        return new RandomRule();
//    }
}
