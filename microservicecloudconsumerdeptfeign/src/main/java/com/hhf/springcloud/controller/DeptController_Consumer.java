package com.hhf.springcloud.controller;

import com.hhf.springcloud.model.Dept;
import com.hhf.springcloud.service.DeptClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by cw on 2018/7/31.
 */
@RestController
@Slf4j
public class DeptController_Consumer {


   // private static final String REST_URL_PREFIX = "http://localhost:8001";

    //从Eureka上面有一个叫MICROSERVICECLOUD-DEPT微服务名字，按名字访问的微服务
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeptClientService service;


    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery",  Object.class);
    }


    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return service.list();
    }
}
