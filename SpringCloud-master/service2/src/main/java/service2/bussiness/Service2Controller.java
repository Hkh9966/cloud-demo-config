package service2.bussiness;

import entity.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/provider/")
public class Service2Controller {

    @GetMapping("getAllDep")
    public List<Department> getAllDep(){
        List<Department> list = new ArrayList<Department>();
        list.add(new Department(1L,"啦啦队","mysql"));
        list.add(new Department(2L,"足球队","mysql"));
        list.add(new Department(3L,"篮球队","mysql"));
        return list;
    }

    @GetMapping("getClientInfo")
    public String getClientInfo(@RequestHeader("hostName") Integer hostName){
        return "HostName:"+hostName;
    }
}
