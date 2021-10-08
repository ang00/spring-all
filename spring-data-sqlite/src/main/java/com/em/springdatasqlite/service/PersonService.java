package com.em.springdatasqlite.service;

import com.em.springdatasqlite.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/16 14:49:42
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
public interface PersonService {
    void save(Person person);
    void saveAll(List<Person> list);
    List<Person> query();
    Page<Person> findAll(int page, int size, String name);
    Person findById(long id);
    long findMinId();
    long findMaxId();
    List<Person> findPage(Long id, Pageable pageable);
    Person create(String name, String message);
    Person update(long id, String name, String message) throws Exception;
}
