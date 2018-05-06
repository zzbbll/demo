package com.example.service.impl;

/**
 * @author: zhang
 * @Date
 **/
import com.example.dao.ProductMapper;
import com.example.model.Person;
import com.example.service.PersonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: zhang
 * @Date: 
**/
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class PersonServiceImpl implements PersonService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Person> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Page<Person> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return productMapper.findByPage();
    }

    /**
     * @author: zhang
     * @Date: 20:47 2018/5/4
    **/
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void insert(Person person) {
        productMapper.insert(person);
    }

}
