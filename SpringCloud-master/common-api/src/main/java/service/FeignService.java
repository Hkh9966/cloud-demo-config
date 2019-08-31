package service;

import Fallback.DepServiceFallback;
import entity.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 针对于部门的服务调用接口
 */
@FeignClient(value = "PROVIDER",fallbackFactory = DepServiceFallback.class) //这里绑定微服务
public interface FeignService {
    //指定url 注意：这里不能使用GetMapping   PostMapping这种混合注解!
    @RequestMapping(value = "/provider/getAllDep",method = RequestMethod.GET)
    List<Department> getAllDep();

    @RequestMapping(value = "/provider/getClientInfo",method = RequestMethod.GET)
    String getClientInfo(@RequestHeader("hostName") String hostName);
}
