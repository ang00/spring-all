package com.em.springelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/13 11:00:48
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "citys")
public class City implements Serializable {
    @Id
    private String id;
//    @Field(type = FieldType.Auto)
    private String name;
    private String pid;
    private String message;
}
