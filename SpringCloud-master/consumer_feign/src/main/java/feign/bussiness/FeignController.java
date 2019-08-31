package feign.bussiness;

import com.netflix.discovery.converters.Auto;
import entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.FeignService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/feign/")
public class FeignController {

    @Autowired
    FeignService service;

    @GetMapping(value = "getAllDep")
    public List<Department> getAllDep(){
        return service.getAllDep();
    }

    @GetMapping("getHostName")
    public String getHostName(HttpServletRequest request){
        return service.getClientInfo(request.getHeader("Host"));
    }

}
