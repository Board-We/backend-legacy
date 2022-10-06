package com.bf.bambooforest.repository;

import com.bf.bambooforest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
