package com.jml.sharding.db.slave;

import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SpringBootConfiguration.class})//shardingjdbc数据源配置信息
public class ShardingDbSlaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingDbSlaveApplication.class, args);
    }
}
