package com.em.springdatasqlite.handler;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.kickstart.spring.error.ErrorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/27 17:55:23
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
//@Component
//public class ConstraintExceptionHandler {
//    /**
//     * 全局异常处理 获取注解异常并进行拦截自定义返回
//     * @param ex
//     * @param ctx
//     * @return
//     */
//    @ExceptionHandler(ConstraintViolationException.class)
//    public GraphQLError constraintViolationException(ConstraintViolationException ex, ErrorContext ctx){
//        return GraphqlErrorBuilder.newError()
//                .message(ex.getMessage())
//                .locations(ctx.getLocations())
//                .path(ctx.getPath())
//                .build();
//    }
//}
