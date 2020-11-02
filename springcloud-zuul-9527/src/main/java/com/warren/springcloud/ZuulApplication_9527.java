package com.warren.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class,args);

/*
    9527端口 + 服务名称（只有小写可以） + 接口路径
        http://localhost:9527/springcloud-provider-dept/dept/get/1
        http://localhost:9527/SPRINGCLOUD-PROVIDER-DEPT/dept/get/1
*/
    }
}
