package com.em.springdatasqlite.service.impl;

import com.em.springdatasqlite.entity.Person;
import com.em.springdatasqlite.service.PersonService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/24 14:52:36
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonServiceImplTest {

    @Resource
    private PersonService personService;

    @Test
    public void findAll() {
        List<Person> content = personService.findAll(0, 100, "100")
                .getContent();
        Assert.assertFalse(content.isEmpty());
        content.forEach(System.out::println);
    }
}
