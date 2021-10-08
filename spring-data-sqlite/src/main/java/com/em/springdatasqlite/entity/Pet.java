package com.em.springdatasqlite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/22 22:10:06
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements Serializable {
    private long id;

    @Length(min = 2, max = 40, message = "名称长度是2-40")
    private String name;

    private Animal type;

    @Range(min = 1, max = 120, message = "年龄范围是1-120")
    private Integer age;

//    public Pet() {
//    }
//
//    public Pet(long id, String name, Animal type, int age) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//        this.age = age;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Animal getType() {
//        return type;
//    }
//
//    public void setType(Animal type) {
//        this.type = type;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
