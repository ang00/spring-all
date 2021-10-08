package com.em.springdatasqlite.resolvers;

//import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.em.springdatasqlite.entity.Person;
import com.em.springdatasqlite.pojo.PageResult;
import com.em.springdatasqlite.service.PersonService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/22 22:50:16
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Slf4j
@Component
public class PersonQuery implements GraphQLQueryResolver {
    @Resource
    private PersonService personService;

    /**
     * 创建线程池
     */
    @SuppressWarnings(value = "all")
    private final ExecutorService executorservice = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @PreDestroy
    private void destroy() {
        executorservice.shutdown();
    }

    public CompletableFuture<Collection<Person>> personAll() {
        log.info("start personAll --- >> ");
        CompletableFuture<Collection<Person>> future = CompletableFuture.supplyAsync(() -> {
            log.info("invoke personAll ...");
            sleep();
            return personService.query();
        }, executorservice);
        log.info("end personAll ---> ");
        return future;
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.error(" ==>> sheep error");
            e.printStackTrace();
        }
    }


    /**
     * -------------------------
     */

    public List<Person> personPage() {
        System.out.println("====> ");
        System.out.println("测试信息 ");
        return personService.query();
    }

    public Person findPersonById(long id) {
        return personService.findById(id);
    }

    public PageResult<Person> findPersonPage(int page, int size, String name) {
        Page<Person> all = personService.findAll(page, size, name);
        PageResult<Person> objectPageResult = new PageResult<>();
        objectPageResult.setItems(all.getContent());
        objectPageResult.setPageNo(page);
        objectPageResult.setPageSize(size);
        objectPageResult.setTotalCount(all.getTotalPages());
        return objectPageResult;
    }

//    public Connection<Person> findPersonsConnection(int first, String after) {
//        String afterToUsed = StringUtils.defaultIfEmpty(after, "0");
//        long minId = personService.findMinId();
//        long maxId = personService.findMaxId();
//        List<Person> page = personService.findPage(Long.valueOf(afterToUsed), PageRequest.of(0, first + 1));
//        List<Edge<Person>> collect = page
//                .stream()
//                .limit(first)
//                .map(p -> new DefaultEdge<>(p, new DefaultConnectionCursor(String.valueOf(p.getId()))))
//                .collect(Collectors.toList());
//        PageInfo pageInfo = new DefaultPageInfo(
//                new DefaultConnectionCursor(String.valueOf(minId)),
//                new DefaultConnectionCursor(String.valueOf(maxId)),
//                Long.parseLong(afterToUsed) > minId,
//                page.size() > first);
//        return new DefaultConnection<>(collect, pageInfo);
//    }

//    public PageResult<Person> findAllPage(int page, int size, String name){
//        Page<Person> all = personService.findAll(page, size, name);
//        PageResult<Person> pageResult = new PageResult<>();
//        pageResult.se
//
//    }

}
