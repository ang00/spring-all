package com.em.springdatasqlite.resolvers;

//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.em.springdatasqlite.entity.Person;
import com.em.springdatasqlite.pojo.PersonInput;
import com.em.springdatasqlite.service.PersonService;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/23 11:12:00
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Slf4j
@Validated
@Component
public class PersonGraphQLMutationResolver implements GraphQLMutationResolver {
    @Resource
    private PersonService personService;

    public Person savePerson(@Valid PersonInput input){
        return personService.create(input.getName(), input.getMessage());
    }

    public Person createPerson(@Valid String name, @Valid String message) {
        System.out.println(" create Person ");
        return personService.create(name, message);
    }

    public Person updatePersonById(long id, String name, String message) throws Exception {
        System.out.println(" update person ");
        return personService.update(id, name, message);
    }


}
