package com.zmfx.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;
    /**
     * 同时添加两条记录
     */
    @Transactional  //加入事务控制
    public void addTwoDog(){
        //模拟两条数据
        Dog dog1=new Dog();
        dog1.setAge(2);
        dog1.setName("小黑1");
        //模拟第二条数据
        Dog dog2=new Dog();
        dog2.setAge(2);
        dog2.setName("小黑2");
        System.out.println("进入了service");
        //将数据插入到数据库
        dogRepository.save(dog1);
        System.out.println(5/0);//模拟异常
        dogRepository.save(dog2);
    }
}
