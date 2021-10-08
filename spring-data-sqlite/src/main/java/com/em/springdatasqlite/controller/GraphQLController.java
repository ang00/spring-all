//package com.em.springdatasqlite.controller;
//
//import com.fasterxml.jackson.databind.JsonSerializer;
//import graphql.servlet.internal.ExecutionResultHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ServerWebExchange;
//
///**
// * @Author: zhangyy
// * @Email: zhang10092009@hotmail.com
// * @Date: 2021/9/18 10:14:57
// * @Version: v1.0
// * @Modified：
// * @Description:
// */
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(path = {
//        "/graphql/person",
//        "/v2"
//}, produces = MediaType.APPLICATION_JSON_VALUE)
//public class GraphQLController {
//
//    static String APPLICATION_GRAPHQL_VALUE = "application/graphql";
//    static MediaType APPLICATION_GRAPHQL = MediaType.parseMediaType(APPLICATION_GRAPHQL_VALUE);
//
//    @Autowired
//    GraphQLInvocation graphQLInvocation;
//
//    @Autowired
//    ExecutionResultHandler executionResultHandler;
//
//    @Autowired
//    JsonSerializer jsonSerializer;
//
//    @PostMapping(value = "${graphql.url:graphql}")
//    public ResponseEntity<Object> graphqlPOST(@RequestHeader(value = HttpHeaders.CONTENT_TYPE, required = false) String contentType,
//                                              @RequestParam(value = "query", required = false) String query,
//                                              @RequestParam(value = "operationName", required = false) String operationName,
//                                              @RequestParam(value = "variables", required = false) String variablesJson,
//                                              @RequestBody(required = false) String body,
//                                              ServerWebExchange serverWebExchange) {
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
