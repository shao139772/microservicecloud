package com.hhf.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cw on 2018/8/8.
 */
@RestController
public class ConfigClientRest {


    private Logger logger = LoggerFactory.getLogger(ConfigClientRest.class);


    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getconfig() {
        String str = "applicationName " + applicationName + " eurekaServers " + eurekaServers + " port " + port;

        logger.info("str " + str);
        return str;
    }

}
