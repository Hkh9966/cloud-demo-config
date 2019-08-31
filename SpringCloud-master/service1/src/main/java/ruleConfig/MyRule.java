package ruleConfig;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

/**
 * 自定义轮询算法 要求 每台机器访问五次后 轮询至下一台 如此循环
 */

public class MyRule extends AbstractLoadBalancerRule {
    Random rand = new Random();

    public MyRule() {
    }
    //当前服务器下标
    private int index = 0;
    //访问次数
    private int currentTotal = 0;

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }


                if(currentTotal==5){
                    index ++;
                    currentTotal = 0;
                }
                if(index >=  upList.size()){
                    index = 0;
                }
                server= (Server) upList.get(index);
                currentTotal++;

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }
    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
