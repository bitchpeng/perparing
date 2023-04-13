package com.bitchpeng.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bitchpeng.canal.mapper")
public class CannelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CannelApplication.class, args);
    }

}
