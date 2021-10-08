package com.em.springdatasqlite.handler;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/28 14:09:05
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Slf4j
@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        log.error("GraphQLError : [{}]", list);
        return Collections.singletonList(new GenericGraphQLError("参数异常，请稍候重试！"));
    }
}
