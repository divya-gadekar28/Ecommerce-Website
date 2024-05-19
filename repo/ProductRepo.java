package com.inn.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inn.ecommerce.model.Product;

public interface ProductRepo extends JpaRepository <Product, Long>{

	List<Product> findAllByCategoryId(int id);
}
