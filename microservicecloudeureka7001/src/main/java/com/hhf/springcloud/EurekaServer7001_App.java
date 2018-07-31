package com.hhf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by cw on 2018/7/31.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001_App {

    public static void main(String[] args) {
        SpringApplication.run(
                EurekaServer7001_App.class,args
        );
    }
}
