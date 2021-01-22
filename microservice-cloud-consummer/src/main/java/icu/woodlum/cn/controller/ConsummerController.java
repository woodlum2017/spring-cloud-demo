package icu.woodlum.cn.controller;

import icu.woodlum.cn.entity.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author woodlum
 * @create 2020-11-26 15:09
 */
@RestController
public class ConsummerController {
    // ribbon负载均衡下，访问的是微服务名称
    private static final String REST_URL_PRE = "http://MIRCROSERVICE-CLOUD-PROVIDER";
    //设置Rest访问地址
//    private static final String REST_URL_PRE = "http://127.0.0.1:8001";
    private RestTemplate restTemplate;
    public ConsummerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("/list")
    public List<Person> list() {
        return restTemplate.getForObject(REST_URL_PRE + "/user/list", List.class);
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable int id){
        return restTemplate.getForObject(REST_URL_PRE + "/user/{id}",
                Person.class,id);
    }
    @GetMapping("/add/{name}/{age}")
    public int insert(@PathVariable("name") String name,@PathVariable("age") String age){
        Person person = new Person(name, Integer.parseInt(age));
        return restTemplate.getForObject(REST_URL_PRE + "/user/{name}/{age}",
                Integer.class,person.getName(),person.getAge());
    }
    @GetMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PRE + "/user/discovery",Object.class);
    }
}
