package com.jml.order;


import com.jml.feign.clients.UserClient;
import com.jml.feign.config.FeignClinetConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/**
 *
 * 1、指定FeignClient所在包basePackages = ""
 * 2、指定FeignClient字节码clients = {}
 */
@EnableFeignClients(defaultConfiguration = FeignClinetConfiguration.class,clients = {UserClient.class})
public class OrderNacosOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacosOpenFeignApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
