package com.example.model.bean;

import lombok.Data;

import java.util.List;

/**
 * @author: zhang
 * @Date
 **/
@Data
public class CarInfoBean {

    private String moduleName;

    private Integer index;

    private List<DescriptionBean> description;


}
