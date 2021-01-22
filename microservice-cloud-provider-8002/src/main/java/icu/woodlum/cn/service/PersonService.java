package icu.woodlum.cn.service;

import icu.woodlum.cn.entity.Person;

import java.util.List;

/**
 * @author woodlum
 * @create 2020-11-11 11:53
 */
public interface PersonService {
    List<Person> getList();
    Person getPersonById(int id);
    int insert(String name, String age);
}
