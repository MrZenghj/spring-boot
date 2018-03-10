package com.snipe.service;

import com.snipe.enums.ResultEnum;
import com.snipe.exception.PeopleException;
import com.snipe.pojo.People;
import com.snipe.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    //获取所有people
    public List<People> getAll(){
        return peopleRepository.findAll();
    }

    //通过 id 查询单个people(有问题)
    public People getOne(Integer id){
        return peopleRepository.getOne(id);
    }
    //添加people
    public People savePeople(People people){
        return peopleRepository.save(people);
    }

    //更新people
    public People updatePeople(People people){
        return peopleRepository.save(people);
    }

    //删除people
    public void deletePeople(Integer id){
        peopleRepository.deleteById(id);
    }

    //通过名字查询
    public List<People> findByName(String name){
        return peopleRepository.findByName(name);
    }

    /**
     * 通过id获取people判断people的年龄是否大于18
     *
     */
    public void getAge(Integer id) throws Exception {
        People people = peopleRepository.getOne(id);
        Integer age = people.getAge();
        if(age<10){
            //直接抛出的话格式跟我们希望输出给浏览器的格式不一样
            //throw new Exception("你的年龄小于10,还在上小学吧");
            //通过枚举容易修改
            throw new PeopleException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            //throw new Exception("你的年龄介于10-16,上初中吧");
            //通过枚举容易修改
            throw new PeopleException(ResultEnum.MIDDLE_SCHOOL);
        }
        //.....其他可能
    }

    //事务控制 （测试）
    @Transactional
    public void testTrans(){

        People peopleA = new People();
        peopleA.setWeight(50.0);
        peopleA.setName("A");
        peopleA.setAge(20);
        peopleRepository.save(peopleA);

       // throw new RuntimeException("运行异常");

    }
}
