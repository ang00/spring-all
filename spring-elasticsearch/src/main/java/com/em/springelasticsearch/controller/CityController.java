package com.em.springelasticsearch.controller;


import com.em.springelasticsearch.entity.City;
import com.em.springelasticsearch.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHitsIterator;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/13 10:59:55
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/city")
public class CityController {

    private CityRepository cityRepository;
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    public CityController(CityRepository cityRepository, ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.cityRepository = cityRepository;
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody City city) {
        return new ResponseEntity<>(cityRepository.save(city), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody City city) {
        return new ResponseEntity<>(cityRepository.save(city), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getById(String id) {
//        cityRepository.findById(id)
        City city = elasticsearchRestTemplate.get(id, City.class);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> findByMessage(String message) {
        return new ResponseEntity<>(cityRepository.findAllByString(message), HttpStatus.OK);
    }

    @GetMapping("/searchPage")
    public ResponseEntity<Object> findByName(String name, int page, int size) {
        return new ResponseEntity<>(cityRepository.findAllByName(name, PageRequest.of(page, size)), HttpStatus.OK);
    }

    @GetMapping("/searchStream")
    public ResponseEntity<Object> searchStream(String name) {
        IndexCoordinates index = IndexCoordinates.of("citys");

        Query query = new NativeSearchQuery(QueryBuilders.matchAllQuery().queryName(name));

//        NativeSearchQuery query = new NativeSearchQueryBuilder()
//                .withQuery(matchAllQuery().queryName(name))
//                .withFields("message")
//                .withPageable(PageRequest.of(0, 10))
//                .build();
        SearchHitsIterator<City> stream = elasticsearchRestTemplate.searchForStream(query, City.class, index);

        List<City> sampleEntities = new ArrayList<>();
        while (stream.hasNext()) {
            sampleEntities.add(stream.next().getContent());
        }

        stream.close();
        return new ResponseEntity<>(sampleEntities, HttpStatus.OK);
    }
}
