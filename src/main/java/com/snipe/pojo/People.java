package com.snipe.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 *    通过注解自动创建实体表
 * */
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class People {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "名字为必填项")
    private String name; //名字
    @Min(value = 18,message = "未满十八岁")  //@NotNull 不能为空// @Max()最大 // @Length()长度为
    private Integer age; //年龄
    @Max(value = 200)
    private Double weight; //体重 kg为单位

    public People() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
