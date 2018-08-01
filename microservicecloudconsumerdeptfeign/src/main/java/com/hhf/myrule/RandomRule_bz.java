package com.hhf.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cw on 2018/8/1.
 * 原文地址  https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java
 */

//自定义的rule  需求每个服务要请求5次，再请求下一个   ,我们目前只有3个微服务
@Slf4j
@Component
public class RandomRule_bz extends AbstractLoadBalancerRule {


    //服务的索引
    private int index = 0;

    //服务调用的次数
    private int count = 0;


    //负载均衡最核心的算法
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            //取得所有在线的服务
            List<Server> upList = lb.getReachableServers();
            //取得所有的服务
            List<Server> allList = lb.getAllServers();
            //未注册服务，返回null
            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            /*int index = chooseRandomInt(serverCount);
            server = upList.get(index);*/


            //未满5次,则被调用的次数+1
            if (count < 5) {
                server = upList.get(index);
                count++;
            } else {
                //超过5次   ，调用的次数重置为0
                count = 0;
                index++;


                //我们的服务数量只有3个，所以我们的索引数不能大于我们的服务数量.达到最大数量时，要重置！
                if (index >= upList.size()) {
                    index = 0;
                }


            }


            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
