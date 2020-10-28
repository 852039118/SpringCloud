package com.warren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 启动类
@SpringBootApplication
@EnableEurekaClient // 在服务启动之后自动注册到Eureka中！（先开Server再开Client才可以注册进去）
@EnableDiscoveryClient  // 服务发现~
@EnableCircuitBreaker   // 增加对熔断器的支持
public class DeptProvider_Hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_Hystrix_8001.class,args);
    }
}
