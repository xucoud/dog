package com.zmfx.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Dog {
    /*
        如果这些注解所在的包，javax.persistence不能导入。可能是缺少依赖
        可以在pom中加入Javax Persistence API 的依赖
     */
    @Id
    @GeneratedValue
    private Integer id;//编号
    private Integer age;//年龄
    private String name;//名字

    public Dog() {
    }

    public Dog(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
