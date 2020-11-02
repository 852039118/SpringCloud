package com.warren.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    // 如果远程没有配置此属性，项目启动时就会报错
    @Value("${spring.profiles.active}")
    private String profile;

    @RequestMapping("/getConfig")
    public String getConfig(){
//        return "applicationName => " + applicationName + '\t' +
//                "eurekaServer => " + eurekaServer + '\t' +
//                "port => " + port + '\t';

        return "applicationName => " + applicationName + '\t' +
                "eurekaServer => " + eurekaServer + '\t' +
                "port => " + port + '\t' +
                "profile => " + profile + '\t' ;
    }
}
