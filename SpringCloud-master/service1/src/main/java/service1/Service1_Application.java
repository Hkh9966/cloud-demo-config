package service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import ruleConfig.MyRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "consumer",configuration = MyRule.class)
public class Service1_Application {
    public static void main(String[] args) {
        SpringApplication.run(Service1_Application.class,args);
    }
}
