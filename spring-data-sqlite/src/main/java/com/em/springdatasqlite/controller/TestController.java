//package com.em.springdatasqlite.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Map;
//
///**
// * @Author: zhangyy
// * @Email: zhang10092009@hotmail.com
// * @Date: 2021/9/18 16:34:56
// * @Version: v1.0
// * @Modified：
// * @Description:
// */
//@RestController
//public class TestController {
//    //    @PassToken
//    @PostMapping("/test01")
//    public ResponseEntity<?> test1(HttpServletRequest httpServletRequest) {
////        System.out.println(map);
//        String message = httpServletRequest.getParameter("message");
//        System.out.println(message);
//        return new ResponseEntity<>(message, HttpStatus.OK);
//    }
//
//    //    @PassToken
//    @PostMapping("/test02")
//    public String test2(@RequestParam String message, @RequestParam(required = false) String test, @RequestParam(required = false) String age) {
////        System.out.println(map);
////        String message = httpServletRequest.getParameter("message");
//        System.out.println("message " + message);
////        System.out.println("test "+test);
////        System.out.println("age "+age);
//        return message;
//    }
//
//    //    }
////    @PassToken
//    @PostMapping("/test03")
//    public ResponseEntity<?> test3(@RequestBody Map<String, String> message) {
//        //        System.out.println(map);
//        //        String message = httpServletRequest.getParameter("message");
//        System.out.println(message);
//        return new ResponseEntity<>(message, HttpStatus.OK);
//    }
//}
