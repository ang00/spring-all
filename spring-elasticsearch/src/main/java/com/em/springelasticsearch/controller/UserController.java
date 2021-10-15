package com.em.springelasticsearch.controller;

import com.em.springelasticsearch.entity.User;
import com.em.springelasticsearch.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/11 15:28:53
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserRepository userRepository;

    @PostMapping("/add")
    public String add(String username, String password, Integer age) {
        User user = new User();
        user.setAge(age);
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user).getId().toString();
    }

    @DeleteMapping
    public String delete(String id) {
        userRepository.deleteById(id);
        return "success";
    }

    @PutMapping
    public String update(String id, String username, String password, Integer age) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setAge(age);
            userRepository.save(user);
            return "success";
        }
        return "No Fond";
    }

    @GetMapping
    public User getUser(String id) {
        Optional<User> byId = userRepository.findById(id);
        System.out.println("存在与否 : " + byId.isPresent());
        return byId.isPresent() ? byId.get() : new User();
    }

    @GetMapping("/all")
    public List<User> all() {
         List<User> list = new ArrayList<>();
         userRepository.findAll().forEach(u -> list.add(u));
         return list;
    }
}
