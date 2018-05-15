package com.zmfx.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  //由于后面自动装配@Autowired时能扫描到此类
@ConfigurationProperties(prefix = "dev")//指明了配置文件中前缀为 dev封装成对象
public class Developer {
    private String name;//姓名
    private Integer age;//年龄
    private Integer id;//编号

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
