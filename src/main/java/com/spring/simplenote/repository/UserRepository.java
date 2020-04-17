package com.spring.simplenote.repository;

import com.spring.simplenote.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
