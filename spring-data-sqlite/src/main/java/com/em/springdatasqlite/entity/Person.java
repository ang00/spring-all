package com.em.springdatasqlite.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/16 10:17:11
 * @Version: v1.0
 * @Modified：人员信息
 * @Description:
 */
@Data
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Max(value = 64, message = "最大长度为64为")
    @NotBlank(message = "名称不为空")
    private String name;

    private String message;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @CreatedBy
    private String createUser;

    @LastModifiedBy
    private String updateUser;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Person(Long id, @Max(value = 64, message = "最大长度为64为") @NotBlank(message = "名称不为空") String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }
}
