package com.example.service;

/**
 * @author: zhang
 * @Date
 **/
import com.example.model.Person;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by yuhao.wang on 2017/6/19.
 */
public interface PersonService {

    List<Person> findAll();

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<Person> findByPage(int pageNo, int pageSize);

    void insert(Person person);
}
