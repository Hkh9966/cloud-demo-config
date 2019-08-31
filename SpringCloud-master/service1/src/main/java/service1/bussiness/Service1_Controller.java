package service1.bussiness;

import com.netflix.discovery.converters.Auto;
import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/")
public class Service1_Controller {

    @Autowired
    RestTemplate restTemplate;

    public static final String URL = "http://PROVIDER/";

    @GetMapping("sayHey")
    public String sayHey(){
        return "hey,I'm consumer.";
    }

    @GetMapping("getAllDep")
    public List<Department> getAllDep(){
        return restTemplate.getForObject(URL+"provider/getAllDep",List.class);
    }

}
