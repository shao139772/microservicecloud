package com.hhf.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cw on 2018/7/31.
 */
@Configuration
public class ConfigBean {
    /**
     * RestTemplate提供了多种便捷访问远程Http服务的方法，
     * 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集。
     * LoadBalanced 使客户端在访问的时候采用负载均衡算法======》默认的为轮询
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    /**
     * 将默认的轮询策略替换成随机策略
     * @return
     */
   /* @Bean
    public IRule myRule(){
        return new RandomRule();
    }*/

}
