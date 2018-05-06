package com.example.model.bean;

import lombok.Data;

import java.util.List;

/**
 * @author: zhang
 * @Date
 **/

@Data
public class DescriptionBean {

    private String type;

    private String label;
    private String submit;
    private String prop;
    private String isRequire;
    private String placeholder;
    private String col;
    private RulesBean rules;
    private List<String> options;
    private String valueFormat;

}
