package com.zmfx.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里的@RestController   相当于@ResponseBody + @Controller
 */
//@RestController
@Controller
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloSpringBoot(){
        return "Hello SpringBoot!";
    }

    //@Value注解用来读取配置文件中对应的值
    @Value("${pageSize}")
    private Integer pageSize;
    @Value("${devName}")
    private String devName;
    @RequestMapping(value = "/showInfo",method = RequestMethod.GET)
    public String showInfo(){
        return "pageSize:"+pageSize+"，devName:"+devName;
    }

    //配置中使用配置
    @Value("${content}")
    private String content;
    @RequestMapping("/content")
    public String printContent(){
        return content;
    }

    //属性封装到对象中提取
    @Autowired
    private Developer developer;
    @RequestMapping(value = "/developer",method = RequestMethod.GET)
    public String showDeveloper(){
        return developer.toString();
    }
    //@ResponseBody
    @RequestMapping(value = "/json",method = RequestMethod.GET)
    public Developer showJson(){
        return developer;
    }

    //templates的展示
    @RequestMapping(value = {"/t","/temp","/template"} ,method = RequestMethod.GET)
    public String showIndexHtml(){
        return "index";
    }

}
