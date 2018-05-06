package com.example.model;

import com.example.model.bean.ParamsBean;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author: zhang
 * @Date
 * 自定义实体类
 **/
@Data
public class JsonBean {

    @Id
    private String id;

    private String host;

    private String baseUrl;

    private String title;

    private ParamsBean params;

}
