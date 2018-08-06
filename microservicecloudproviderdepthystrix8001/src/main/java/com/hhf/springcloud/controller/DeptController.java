package com.hhf.springcloud.controller;

import com.hhf.springcloud.model.Dept;
import com.hhf.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cw on 2018/7/30.
 */
@RestController
@Slf4j
public class DeptController {


    @Autowired
    private DeptService service;


    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept result = service.get(id);

        if (result == null) {
            throw new RuntimeException("没有这个部门");
        }
        return result;
    }



    //正确的返回
    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand").setDb_source("no this database in MySQL");
    }


    //测试能否返回和原先不一样的类型    不行，只能返回相同类型或者其子类
  /*  public Map processHystrix_Get(@PathVariable("id") Long id) {
        Map result=new HashMap<String,Object>();
      result.put("id",id);
      result.put("code",-1);
      result.put("msg","failed ! no dept");
        return result;
    }*/


}


