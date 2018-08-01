package com.hhf.myrule;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cw on 2018/7/31.
 */

@Configuration
public class MyRule {


    @Bean
    public IRule selfRule(){
       /* 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，
        还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问*/
      //  return  new AvailabilityFilteringRule();
        return new RandomRule_bz();
    }
}
