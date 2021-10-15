package com.em.springelasticsearch.repository;

import com.em.springelasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/11 15:27:29
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {

}
