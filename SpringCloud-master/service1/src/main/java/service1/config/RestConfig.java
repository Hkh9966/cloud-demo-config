package service1.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ruleConfig.MyRule;

@Configuration
public class RestConfig {
    @Bean
    @LoadBalanced //客户端负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule myRule(){ //配置负载均衡算法
        return new MyRule(); //随机算法
    }
}
