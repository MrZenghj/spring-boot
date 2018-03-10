package com.snipe.controller;

import com.snipe.pojo.People;
import com.snipe.properties.PeopleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *    该类用于熟悉spring-boot的一些属性
 */
@RestController
public class HelloController {

    @Autowired
    private PeopleProperties peopleProperties; //通过配置注入属性


    /**
     *    // @RestController 控制层标签：返回json格式
     *    //作用等于@Controller+@ResponseBody
     *    method的方法有很多主要为 GET、POST、PUT、DELETE
     *    value为请求URL
     */
    @RequestMapping(value = "/sayHi",method = RequestMethod.GET)
    public String sayHi(){
        return "hello to spring-boot";
    }
    /**
     *      //GetMapping(value = "/hello")  作用等同于
     *      //@RequestMapping(value = "/hello",method = RequestMethod.GET)
     *      同理类推：
     *      //PostMapping、PutMapping、DeleteMapping
     *
     * */
    @GetMapping(value = "/hello") //value可以省略
    public String hello(){
        return "hello to spring-boot";
    }

    /*********************************     参数获取 *********************************************/

    /**
     *  //@RequestParam 参数注入
     *          value 请求传入的参数名
     *          defaultValue 默认值 如果不传过来则使用默认值
     *          required 参数是否必须 true false
     * */
    @GetMapping("/getParam")
    public String getParam(@RequestParam(value = "name",defaultValue = "snipe",required = true)String name){
        return name;
    }

    /**
     *  通过URL传参数
     *      // @PathVariable("name") 获取url中对应的参数
     *      访问地址 例：/getParam/snipe 则获取snipe
     * */
    @GetMapping("/getParam/{name}")
    public String getParams(@PathVariable("name") String name){
        return name;
    }
    /**
     *  通过属性实体注入
     * */
    @PostMapping("/getPeople")
    public People getPeople(People people){
        return people;
    }

    /**
     *  通过配置注入属性
     * */
    @GetMapping("/getPeople")
    public People getMan(){
        People people = new People();
        people.setAge(peopleProperties.getAge());
        people.setName(peopleProperties.getName());
        people.setWeight(peopleProperties.getWeight());
        return people;
    }
}
