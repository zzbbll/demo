package com.example.dao;

import com.example.model.JsonBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMongodb extends MongoRepository<JsonBean,String> {
}
