package icu.woodlum.cn.service;

import feign.hystrix.FallbackFactory;

import icu.woodlum.cn.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author woodlum
 * @create 2020-12-16 14:19
 */
@Component
public class PersonClientServiceFallbackFactory implements FallbackFactory<PersonClientService> {

    @Override
    public PersonClientService create(Throwable throwable) {
        return new PersonClientService() {
            @Override
            public List<Person> list() {
                ArrayList<Person> list = new ArrayList<>();
                list.add(new Person().setId(0).setName("服务不可用"));
                return list;
            }

            @Override
            public Person getById(int id) {
                return new Person().setId(id).setName("id:" + id + "数据库中没有对应的信息或此服务已经被关闭");
            }

            @Override
            public int insert(String name, int age) {
                return 0;
            }

            @Override
            public Object discovery() {
                return new String("服务不可用");
            }
        };
    }
}
