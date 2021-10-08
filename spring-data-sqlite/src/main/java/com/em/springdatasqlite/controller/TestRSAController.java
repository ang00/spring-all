//package com.em.springdatasqlite.controller;
//
//import com.em.springdatasqlite.RSAUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author: zhangyy
// * @Email: zhang10092009@hotmail.com
// * @Date: 2021/9/18 12:22:57
// * @Version: v1.0
// * @Modified：
// * @Description:
// */
////@RestController
//@Controller
//@RequiredArgsConstructor
//@RequestMapping(path = {"/RSA"})
//public class TestRSAController {
//    @ResponseBody
//    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity all(@RequestBody RequstRSA vo) throws Exception {
//        System.out.println("message " + vo.getMessage());
//        String data = RSAUtil.publicKeyDecrypt(vo.getContent(), vo.getBase64publicKey());
//        Map<String, String> stringMap = Map.of("data", data, "message", vo.getMessage());
//        return new ResponseEntity(stringMap, HttpStatus.OK);
//    }
//
////    @PostMapping("/soldm")
////    public ResponseEntity<?> searchUsers(@RequestBody MultiValueMap< String, String > values) {
////
////        System.out.println(("K=V Map - {}" + values));
////
//////        REListing reListing=  listingService.getREListingById();
////
////        return new ResponseEntity<>(values, HttpStatus.OK);
////    }
//    @PostMapping(path = "/demo1")
//    public ResponseEntity demo1(@RequestBody Map<String, String> map){
////        System.out.println(map.toString());
//        return new ResponseEntity(map,HttpStatus.OK);
//    }
//
////    @PostMapping(value = "/test")
////    public ResponseEntity<?> query(Map<String,String> valueMap
//////            , @RequestParam(required = false, value = "test") String test
////    ) {
//////        List<String> message = valueMap.get("message");
//////        System.out.println("message : " + message);
//////        System.out.println("test : " + test);
//////        Map<String, String> stringMap = Map.of("message", message);
////        System.out.println("k=v map {}"+ valueMap);
////        return new ResponseEntity(valueMap, HttpStatus.OK);
////    }
//}
