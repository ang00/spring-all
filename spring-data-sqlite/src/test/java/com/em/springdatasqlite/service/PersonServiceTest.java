//package com.em.springdatasqlite.service;
//
//import cn.hutool.http.HttpUtil;
//import com.em.springdatasqlite.entity.Person;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//
///**
// * @Author: zhangyy
// * @Email: zhang10092009@hotmail.com
// * @Date: 2021/9/16 16:04:44
// * @Version: v1.0
// * @Modified：
// * @Description:
// */
//@SpringBootTest
//class PersonServiceTest {
//
//    @Resource
//    private PersonService personService;
//
//    @Test
//    void save() {
////        personService.save(new Person("小明"));
////        personService.save(new Person("小花"));
////        personService.save(new Person("小山", "今天不回家"));
//        for (int i = 0; i < 10000; i++) {
//            personService.save(new Person("小山" + i, "今天不回家" + i));
//        }
//    }
//
//    @Test
//    void query() {
//        personService.query().forEach(System.out::println);
//    }
//
//
//    @Test
//    public void test01() {
//        String body = HttpUtil.createPost("http://192.168.0.107:8091/test02")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .body("message=你好", "application/x-www-form-urlencoded")
//                .execute().body();
//        System.out.println("body :: " + body);
//    }
//}
