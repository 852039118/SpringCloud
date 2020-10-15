package com.warren.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)    // 链式编程
public class Dept implements Serializable { // Dept 实体类     ORM  类表关系映射
    private long deptno;        // 主键
    private String dname;
    // 这个数据 存着哪个数据库的字段~ 微服务，一个服务对应一个数据库，同一个信息可能存在于不同的数据库
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }

    /*
    * 链式写法
    *       Dept dept = new Dept();
    *       dept.setDeptNo(11).setDName('warren').setDb_source('001');
    * */
}
