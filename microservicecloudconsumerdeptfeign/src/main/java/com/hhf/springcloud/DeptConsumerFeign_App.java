package com.hhf.springcloud;

import com.hhf.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Component;

/**
 * Created by cw on 2018/7/31.
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MyRule.class)
@EnableFeignClients(basePackages="com.hhf.springcloud")
@Component(value="com.hhf.springcloud")
public class DeptConsumerFeign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign_App.class, args);
    }
}
