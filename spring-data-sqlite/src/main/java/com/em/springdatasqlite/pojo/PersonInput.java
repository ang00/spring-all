package com.em.springdatasqlite.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Author: zhangyy
 * @Email: zhang10092009@hotmail.com
 * @Date: 2021/9/27 10:54:12
 * @Version: v1.0
 * @Modified：
 * @Description:
 */
@Data
public class PersonInput {
    @NotBlank(message = "名字不为空")
    private String name;
    private String message;
}
