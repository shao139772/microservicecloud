package com.hhf.springcloud.service;

import com.hhf.springcloud.model.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by cw on 2018/8/1.
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
//表示向哪个微服务进行面向接口编程
public interface DeptClientService {


    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept);


}
