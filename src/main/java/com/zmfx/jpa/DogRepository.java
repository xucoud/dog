package com.zmfx.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 这个接口需要继承一个接口JpaRepository
 * 这样就可以使用底层为我们编写好的一些通用方法
 */
public interface DogRepository extends JpaRepository<Dog,Integer> {
    //通过年龄来查询
    List<Dog>  findByAge(Integer age);//注意方法名的格式，findBy+属性名。
}
