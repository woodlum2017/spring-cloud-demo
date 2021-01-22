package icu.woodlum.cn.service;

import icu.woodlum.cn.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author woodlum
 * @create 2020-12-07 14:42
 */
//fegin客户端，value为被调用微服务的名称
//@FeignClient(value = "MIRCROSERVICE-CLOUD-PROVIDER")
//fallbackFactory启用服务降级
@FeignClient(value = "MIRCROSERVICE-CLOUD-PROVIDER",fallbackFactory = PersonClientServiceFallbackFactory.class)
public interface PersonClientService {
    @GetMapping("user/list")
    public List<Person> list();

    @GetMapping("user/{id}")
    public Person getById(@PathVariable int id);

    @GetMapping("user/{name}/{age}")
    public int insert(@PathVariable String name,@PathVariable int age);

    @GetMapping("user/discovery")
    public Object discovery();
}
