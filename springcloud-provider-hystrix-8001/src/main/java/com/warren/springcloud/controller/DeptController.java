package com.warren.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.warren.springcloud.pojo.Dept;
import com.warren.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供Restful服务！
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("id => " + id + "不存在该用户");
        }
        return dept;
    }

    // 备选方法(服务熔断)
    public Dept hystrixGet(@PathVariable("id") long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id => " + id + "不存在该用户--@Hystrix")
                .setDb_source("No this database in MySQL")
                ;
    }
}
