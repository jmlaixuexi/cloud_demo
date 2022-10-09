package com.jml.sharding.db.sharding;

import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SpringBootConfiguration.class})
public class ShardingDbShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingDbShardingApplication.class,args);
    }
}
