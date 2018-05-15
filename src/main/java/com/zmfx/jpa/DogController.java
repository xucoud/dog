package com.zmfx.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 控制层
 */
@RestController
public class DogController {
    //因为业务太简单，所有我们省略service层，直接调用数据访问层的代码
    @Autowired
    private DogRepository dogRepository;
    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value="/dogs")
    public List<Dog> dogList(){
        return dogRepository.findAll();//findAll()方法是底层帮我没实现好的
    }

    /**
     * 根据id查询指定的Dog
     * @param id
     * @return
     */
    @GetMapping(value = "/dog/{id}")
    public Optional<Dog> findDogById(@PathVariable("id") Integer id){
        return dogRepository.findById(id);//注意这个方法的返回值
    }

    /**
     * 添加一个Dog
     * @param age
     * @param name
     * @return
     */
    @PostMapping(value = "/addDog")
    public Dog addDog(@RequestParam("age") Integer age,
                      @RequestParam("name") String name){
        Dog dog=new Dog();
        dog.setAge(age);
        dog.setName(name);
        return dogRepository.save(dog);
    }

    /**
     * 更新Dog信息
     * @param id
     * @param age
     * @param name
     * @return
     */
    @PutMapping(value = "updateDog/{id}")
    public Dog updateDog(@PathVariable("id") Integer id,
                         @RequestParam("age") Integer age,
                         @RequestParam("name") String name){
        Dog dog=new Dog();
        dog.setId(id);
        dog.setName(name);
        dog.setAge(age);
        System.out.println(dog);
        return dogRepository.save(dog);//注意这里使用save()方法，根据主键，所以主键不能更改
    }


    /**
     * 删除一条记录
     * @param id
     */
    @DeleteMapping(value = "/del/{id}")
    public void delDogById(@PathVariable("id") Integer id){
        dogRepository.deleteById(id);
    }

    /**
     * 根据年龄来查询
     */
    @GetMapping(value = "/dogs/{age}")
    public List<Dog> dogList(@PathVariable("age")Integer age){
        return dogRepository.findByAge(age);
    }

    //这里涉及到事务，所以我们加入service的依赖
    @Autowired
    private DogService dogService;
    /**
     * 事务测试的方法
     */
    @GetMapping(value = "/dogs/tx")
    public void txTest(){
        System.out.println("进入了controller");
        dogService.addTwoDog();
    }

}
