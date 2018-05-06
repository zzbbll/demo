package com.example.model;

import lombok.Data;

/**
 * @author: zhang
 * @Date
 **/
@Data
public class Person {
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;
}
