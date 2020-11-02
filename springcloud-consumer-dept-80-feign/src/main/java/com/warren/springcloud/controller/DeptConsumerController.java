package com.warren.springcloud.controller;

import com.warren.springcloud.pojo.Dept;
import com.warren.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
        return this.deptClientService.add(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id){
        System.out.println(111);
        return this.deptClientService.queryById(id);
    }

    @RequestMapping("/dept/list")
    public List<Dept> queryAll(){
        return this.deptClientService.queryAll();
    }
}
