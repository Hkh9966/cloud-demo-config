package discovery2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author lzr
 * @date 2017/4/15
 */

@SpringBootApplication
@EnableEurekaServer
public class Discovery2Applicaion {
    public static void main(String[] args) {
        SpringApplication.run(Discovery2Applicaion.class, args);
    }
}
