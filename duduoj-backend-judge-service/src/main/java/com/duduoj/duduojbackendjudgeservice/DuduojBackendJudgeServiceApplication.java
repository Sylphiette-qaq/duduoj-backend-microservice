package com.duduoj.duduojbackendjudgeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.duduoj")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class DuduojBackendJudgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuduojBackendJudgeServiceApplication.class, args);
    }

}
