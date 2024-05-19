package com.inn.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inn.ecommerce.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
