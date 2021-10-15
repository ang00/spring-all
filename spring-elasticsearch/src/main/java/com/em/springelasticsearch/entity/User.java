package com.em.springelasticsearch.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/10/11 15:23:19
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Data
@Document(indexName = "users")
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private Integer age;
}
