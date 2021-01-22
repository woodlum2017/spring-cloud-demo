package icu.woodlum.cn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.woodlum.cn.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author woodlum
 * @create 2020-11-11 11:52
 */
@Mapper
@Component
public interface PersonDao extends BaseMapper<Person> {
}
