package com.spring.simplenote.repository;

import com.spring.simplenote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
