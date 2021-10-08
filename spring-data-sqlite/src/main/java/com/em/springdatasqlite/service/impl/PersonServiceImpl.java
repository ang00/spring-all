package com.em.springdatasqlite.service.impl;

import com.em.springdatasqlite.entity.Person;
import com.em.springdatasqlite.jpa.PersonRepository;
import com.em.springdatasqlite.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/16 14:50:11
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAll(List<Person> list) {
        list.forEach(p -> personRepository.save(p));
//        personRepository.saveAll(list);
    }

    @Override
    public List<Person> query() {
        return personRepository.findAll();
    }

    @Override
    public Page<Person> findAll(int page, int size, String name) {
        Page<Person> all = personRepository.findAll(
                Example.of(new Person(name), ExampleMatcher.matching()
                        .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())),
                PageRequest.of(page, size, Sort.Direction.DESC, "createTime"));
        all.getContent().forEach(System.out::println);
        return all;
    }

    @Override
    public Person findById(long id) {
        return personRepository.findById(id).orElseGet(Person::new);
    }


    @Override
    public long findMinId(){
        return personRepository.findMinId();
    }
    @Override
    public long findMaxId(){
        return personRepository.findMaxId();
    }

    @Override
    public Person create(String name, String message) {
        return personRepository.save(new Person(name, message));
    }

    @Override
    public List<Person> findPage(Long id, Pageable pageable){
        return personRepository.findByIdGreaterThan(id, pageable);
    }

    @Override
    public Person update(long id, String name, String message) throws Exception {
        Person person = personRepository
                .findById(id)
//                .orElseThrow(() -> new Exception("不存在"));
                .filter(p -> p != null)
                .get();
        person.setMessage(message);
        person.setName(name);
        return personRepository.save(person);
    }
}
