package com.snipe.repository;

import com.snipe.pojo.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  通过继承JpaRepository 实现具体类从而操作表
 * */
public interface PeopleRepository extends JpaRepository<People,Integer>{
    public List<People> findByName(String name);
}
