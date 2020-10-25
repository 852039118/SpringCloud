package com.warren.springcloud.service;

import com.warren.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {
    @RequestMapping("/dept/add")
    public boolean add(@RequestBody Dept dept);

    @RequestMapping("/dept/get/{id}")   //为什么可以和Feign的地址不一致啊，使用的是Feign中Controller的地址
    public Dept get(@PathVariable("id") long id);

    @RequestMapping("/dept/list")
    public List<Dept> queryAll();
}
