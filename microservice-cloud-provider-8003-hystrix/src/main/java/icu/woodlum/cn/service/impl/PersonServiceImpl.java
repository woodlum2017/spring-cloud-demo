package icu.woodlum.cn.service.impl;

import icu.woodlum.cn.dao.PersonDao;
import icu.woodlum.cn.entity.Person;
import icu.woodlum.cn.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author woodlum
 * @create 2020-11-11 11:55
 */
@Service
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> getList() {
        return personDao.selectList(null);
    }

    @Override
    public Person getPersonById(int id) {
        Person person = personDao.selectById(id);
        if (person == null) {
            throw new RuntimeException("id:" + id + "不存在于数据库中");
        }
        return person;
    }

    @Override
    public int insert(String name, String age) {
        return personDao.insert(new Person(name,Integer.parseInt(age)));
    }
}
