package org.tc.appsvr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan({"org.tc.appsvr.mapper*"})
@EnableCaching
@SpringBootApplication
public class AppsvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppsvrApplication.class, args);
    }

}
