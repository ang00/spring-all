package com.em.springelasticsearch.repository;


import com.em.springelasticsearch.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/13 11:03:21
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
public interface CityRepository extends ElasticsearchRepository<City, String> {

    @Transactional(readOnly = true)
    List<City> findAllByMessageLike(String message);

    /**
     * 使用注解进行查询
     * 1.原始查询语句
     * {
     * "query": {
     * "query_string": {
     * "query": "名"
     * }
     * }
     * }
     *
     * @param message
     * @return
     */
    @Query("{\"query_string\":{\"query\":\"?0\"}}")
    List<City> findAllByString(String message);

    /**
     * 查询分页指定字段
     * {
     * "query": {
     * "match": {
     * "name": {
     * "query": "镇"
     * }
     * }
     * }
     * }
     *
     * @return
     */
    @Query("{\"match\":{\"name\":{\"query\":\"?0\"}}}")
    Page<City> findAllByName(String mame, Pageable pageable);

    List<City> findByIdIn(List<String> ids);

    List<City> findByPidIn(Set<String> pid);
}
