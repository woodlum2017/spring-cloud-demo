package icu.woodlum.cn.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import icu.woodlum.cn.entity.Person;
import icu.woodlum.cn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author woodlum
 * @create 2020-11-11 11:56
 */
@RestController
@RequestMapping("/user")
public class PersonController {
    @Autowired
    private PersonService personService;
    // 服务发现
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/list")
    public List<Person> list() {
        return personService.getList();
    }

    @GetMapping("/{id}")
    // 当发生异常时，调用fallbackMethod方法
    @HystrixCommand(fallbackMethod = "getHystrixCommand")
    public Person getById(@PathVariable int id){
        return personService.getPersonById(id);
    }
    //Hystrix熔断时调用的方法
    public Person getHystrixCommand(@PathVariable int id) {
        return new Person().setId(id).setName("id:" + id + "数据库中不存在");
    }

    @GetMapping("/{name}/{age}")
    public int insert(@PathVariable String name,@PathVariable String age){
        return personService.insert(name,age);
    }
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        list.forEach(e -> {
            System.out.println(e);
            List<ServiceInstance> instances = client.getInstances(e);
            instances.forEach(l -> {
                System.out.println(l.getInstanceId() + "|" + l.getHost() + "|" + l.getPort() + "|" + l.getUri() + "|" + l.getScheme() + "|" + l.getMetadata());
            });
        });

        return this.client;
    }

}
