package service3.bussiness;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import entity.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/provider/")
public class Service3Controller {

    @GetMapping("getAllDep")
    //开启熔断机制 如果该方法出现异常 自动调用getAllDefaultDep并返回
    @HystrixCommand(fallbackMethod = "getAllDefaultDep")
    public List<Department> getAllDep(){
        Random random = new Random();
        int count = random.nextInt(5);
        List<Department> list = new ArrayList<Department>();
        for(int i = 0; i<count ;i++ ){
            list.add(new Department(i+1L,"啦啦队","mysql2"));
        }
        if(list.size()<=3){
            throw new RuntimeException("服务出现异常，无法调用");
        }
        return list;
    }

    public List<Department> getAllDefaultDep(){
        List<Department> list = new ArrayList<Department>();
        list.add(new Department(1L,"啦啦队","mysql2"));
        list.add(new Department(2L,"足球队","mysql2"));
        list.add(new Department(3L,"篮球队","mysql2"));
        list.add(new Department(1L,"消防队","mysql2"));
        list.add(new Department(2L,"乐队","mysql2"));
        return list;
    }

    @GetMapping("getClientInfo")
    public String getClientInfo(@RequestHeader String hostName){
        return "HostName:"+hostName;
    }
}
