package com.warren.springcloud.service;

import com.warren.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(long id);

    public List<Dept> queryAll();

}
