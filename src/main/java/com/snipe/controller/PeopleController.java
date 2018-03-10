package com.snipe.controller;

import com.snipe.dto.Result;
import com.snipe.pojo.People;
import com.snipe.service.PeopleService;
import com.snipe.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 *  People 的简单增删改查
 * */
@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    /**
     * restFull规则
     *  获取所有people
     * */
    @GetMapping("/People")
    public List<People> getAll(){
       return  peopleService.getAll();
    }
    /**
     *  通过id 查询单个people
     *  @param id
     *  @return people
     * */
    @GetMapping("/People/find/{id}")
    public People getPeople(@PathVariable("id")Integer id){
        return  peopleService.getOne(id);
    }
    /**
     *  通过name 查询people
     *  @param  name
     *  @return List<People>
     * */
    @GetMapping("/People/find/names")
    public List<People> findByName(@RequestParam("name")String name){
        return  peopleService.findByName(name);
    }

    /**
     *  restFull规则
     *  添加people
     *  数据校验
     *  @param people 需要检验的数据
     *  @param bindingResult 检验数据结果信息的封装
     * */
    @PostMapping("/People")
    public Result<People> savePeople(@Valid People people, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            /*
            Result result = new Result();
            result.setCode(1);
            result.setMessage(bindingResult.getFieldError().getDefaultMessage());
            */
            //返回错误信息
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
            /*
            Result result = new Result();
            result.setCode(0);
            result.setMessage("成功");
            result.setDate(peopleService.savePeople(people));
            */
        return  ResultUtil.success(peopleService.savePeople(people));
    }
    /**
     *  restFull规则
     *  更新people
     * */
    @PutMapping("/People")
    public People updatePeople(People people){
        return  peopleService.updatePeople(people);
    }
    /**
     *  restFull规则
     *  删除people
     * */
    @DeleteMapping("/People")
    public void deletePeople(@RequestParam("id") Integer id){
        peopleService.deletePeople(id);
    }


    /**
     *  事务测试
     * */
    @GetMapping("/People/trans")
    public void testTrans(){
       peopleService.testTrans();
    }

    /**
     *  统一异常处理
     *      事件：判断people的年龄是否大于18
     * */
    @GetMapping("/People/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception {
        peopleService.getAge(id);
    }
}
