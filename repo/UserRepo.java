package com.inn.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inn.ecommerce.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	Optional<User> findUserByEmail(String email);
}
