package com.hhf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by cw on 2018/8/6.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_DashBoard_App {


    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
    }
}
