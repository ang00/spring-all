package com.em.springelasticsearch.service;

import com.em.springelasticsearch.entity.User;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/12 9:18:30
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Component
public class ElasticsearchService {
    private final ElasticsearchRestTemplate restTemplate;

    public ElasticsearchService(ElasticsearchRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User add(User user) {
        return restTemplate.save(user);
    }

    public boolean existsId(long id){
        return restTemplate.exists(String.valueOf(id), User.class);
    }
}
