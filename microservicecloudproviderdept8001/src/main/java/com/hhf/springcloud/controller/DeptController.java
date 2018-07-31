package com.hhf.springcloud.controller;

import com.hhf.springcloud.model.Dept;
import com.hhf.springcloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cw on 2018/7/30.
 */
@RestController
@Slf4j
public class DeptController {


    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;


    /**
     * eureka的服务发现，不是重点了解即可
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        //client.getServices()的意思是获取eureka里面有多少个微服务
        //那么我们如果只有一个微服务是部门，后续我们在工作中可能会有越来越多的微服务
        //那么List查出来的就会有很多的微服务，然后进行遍历然后打印出来
        List<String> list = client.getServices();
       log.info("\"**********\" + list");
        //client.getInstances()的意思就是在那么多的微服务里面，你指定只找哪一个微服务
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            //然后打印你指定要找的微服务的ID和主机和端口以及访问地址等信息
            log.info(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }


    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }
}


