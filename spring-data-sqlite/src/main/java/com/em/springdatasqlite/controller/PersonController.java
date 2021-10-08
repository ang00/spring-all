package com.em.springdatasqlite.controller;

import com.em.springdatasqlite.entity.Person;
import com.em.springdatasqlite.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/16 14:49:17
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = {
        "/SQLite/person"
//        "/",
//        "/v1"
}, produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody Person person) {
        personService.save(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@Validated @RequestBody Person person) {
        personService.save(person);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> queryAll() {
//        List<Person> list = new ArrayList<>();
//        for (long i = 0; i < 10; i++) {
//            personService.save(new Person(i + "小山" + i, "今天不回家" + i));
//            list.add(new Person(i,i + "小山" + i, "今天不回家" + i));
//        }
//        personService.saveAll(list);
        List<Person> query = personService.query();
        query.forEach(System.out::println);
        return new ResponseEntity<>(query, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(@RequestParam int page, @RequestParam int size, @RequestParam(required = false) String name) {
        return new ResponseEntity<>(personService.findAll(page, size, name), HttpStatus.OK);
    }

//    @GetMapping("/")
//    public ResponseEntity get() {
//        return new ResponseEntity("success ++ " + new Date(), HttpStatus.OK);
//    }
}
