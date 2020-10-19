package com.warren.springcloud;

import com.warren.myrule.WarrenRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

// Ribbon 和 Eureka 整合之后，客户端可以直接调用。我们不用再关心IP地址
@SpringBootApplication
@EnableEurekaClient
// 在微服务启动的时候就可以加载我们自定义的Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = WarrenRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
