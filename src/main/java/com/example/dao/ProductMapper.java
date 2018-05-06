package com.example.dao;

import com.example.model.Person;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhang
 * @Date
 * 声明成mybatis Dao层的Bean，也可以在配置类上使用@MapperScan("com.xiaolyuh.domain.mapper")注解声明
 **/
@Repository
@Mapper
public interface ProductMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    /**
     * 获取所有数据
     * @return
     */
    List<Person> findAll();

    /**
     * 分页查询数据
     * @return
     */
    Page<Person> findByPage();
}
