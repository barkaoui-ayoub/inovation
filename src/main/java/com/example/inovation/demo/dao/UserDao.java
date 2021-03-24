package com.example.inovation.demo.dao;

import com.example.inovation.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User,Integer> {
}
