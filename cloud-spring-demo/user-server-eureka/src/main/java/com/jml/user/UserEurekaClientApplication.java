package com.jml.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserEurekaClientApplication.class,args);
    }

}
