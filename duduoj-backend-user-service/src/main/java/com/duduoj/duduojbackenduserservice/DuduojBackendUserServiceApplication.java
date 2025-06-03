package com.duduoj.duduojbackenduserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.duduoj.duduojbackenduserservice.mapper")
@EnableScheduling
@ComponentScan("com.duduoj")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {
        "com.duduoj.duduojbackendserviceclient.service"
})
public class DuduojBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuduojBackendUserServiceApplication.class, args);
    }

}
