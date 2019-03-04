package com.wjianwu.qs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wjianwu")
@MapperScan(basePackages = "com.wjianwu.qs.dao")
public class QsApplication {

    public static void main(String[] args) {
        SpringApplication.run(QsApplication.class, args);
    }

}
