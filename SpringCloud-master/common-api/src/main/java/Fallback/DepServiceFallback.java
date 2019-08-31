package Fallback;

import entity.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import service.FeignService;

import java.util.ArrayList;
import java.util.List;
@Component
public class DepServiceFallback implements FallbackFactory<FeignService> {

    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService(){
            @Override
            public List<Department> getAllDep() {
                List<Department> list = new ArrayList<Department>();
                list.add(new Department(1L,"服务降级，暂停业务","System"));
                return list;
            }

            @Override
            public String getClientInfo(String hostName) {
                return "暂无信息";
            }
        };
    }
}
