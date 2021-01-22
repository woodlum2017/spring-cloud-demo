package icu.woodlum.cn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author woodlum
 * @create 2020-11-10 16:05
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    private int id;
    private String name;
    private int age;
    @JsonIgnore
    private String password;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
