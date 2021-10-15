package com.em.springelasticsearch.repository;

import cn.hutool.core.util.RandomUtil;
import com.em.springelasticsearch.entity.User;
import com.em.springelasticsearch.service.ElasticsearchService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/12 9:06:26
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@SpringBootTest
public class UserRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Resource
    private CityRepository cityRepository;

    @Resource
    private ElasticsearchService elasticsearchService;

    @Test
    public void save(){
        User user = new User();
        user.setAge(RandomUtil.randomInt(10));
        user.setPassword("2323rer");
        user.setUsername("名字");
        User save = userRepository.save(user);
        Assert.notNull(save);
    }

    @Test
    public void add(){
        User user = new User();
        user.setAge(RandomUtil.randomInt(10));
        user.setPassword("2323rer");
        user.setUsername("対看看");
        User save = elasticsearchService.add(user);
        Assert.notNull(save);
    }
    @Test
    public void get(){
//        Optional<User> byId = elasticsearchService.
//        byId.ifPresent(System.out::println);
//        Assert.notNull(byId.get());
    }

    @Test
    public void existsId(){
//        Assert.isTrue(!elasticsearchService.existsId(1L));
//        System.out.println(elasticsearchService.existsId(1L));
        boolean b = userRepository.existsById("1");
        System.out.println("b : " + b);
    }
    @Test
    public void queryAll(){
        Iterable<User> all = userRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void findByIds(){
        cityRepository.findAll().forEach(System.out::println);
        ArrayList<String> objects = new ArrayList<>();
        objects.add("z9_9fXwBJ5oxamB7PFnK");
        objects.add("0t_9fXwBJ5oxamB74lm1");
        objects.add("0N_9fXwBJ5oxamB7mFl4");
        cityRepository.findByIdIn(objects).forEach(System.out::println);
        System.out.println("...............");
        cityRepository.findByIdIn(new ArrayList<>()).forEach(System.out::println);
    }

    @Test
    public void findByPids(){
//        cityRepository.findAll().forEach(System.out::println);
        Set<String> objects = new HashSet<>();
//        objects.add("33");
//        objects.add("334");
        objects.add("4");
        cityRepository.findByPidIn(objects).forEach(System.out::println);
        System.out.println("...............");
        cityRepository.findByPidIn(new HashSet<>()).forEach(System.out::println);
    }
}
