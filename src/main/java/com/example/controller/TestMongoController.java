package com.example.controller;

import com.example.dao.TestMongodb;
import com.example.model.JsonBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhang
 * @Date: 15:54 2018/5/6
**/
@RestController
@RequestMapping(value="/mongo")
@Api(value = "测试自动配置API接口调试")
public class TestMongoController {

    @Autowired
    private TestMongodb testMongodb;

    @GetMapping(value="/")
    @ApiOperation(value = "获取数据列表",notes = "查询")
    public List<JsonBean> getMongoList() {

        return testMongodb.findAll();
    }

}
