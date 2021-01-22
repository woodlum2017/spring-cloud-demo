package icu.woodlum.cn.controller;

import icu.woodlum.cn.entity.Person;
import icu.woodlum.cn.service.PersonClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author woodlum
 * @create 2020-11-26 15:09
 */
@RestController
public class ConsummerController {

    @Autowired
    private PersonClientService personClientService;

    @GetMapping("/list")
    public List<Person> list() {
        return personClientService.list();
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable int id){
        return personClientService.getById(id);
    }
    @GetMapping("/add/{name}/{age}")
    public int insert(@PathVariable("name") String name,@PathVariable("age") String age){
        Person person = new Person(name, Integer.parseInt(age));
        return personClientService.insert(person.getName(),person.getAge());
    }
    @GetMapping("/discovery")
    public Object discovery(){
        return personClientService.discovery();
    }
}
