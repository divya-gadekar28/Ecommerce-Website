package com.inn.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.ecommerce.model.Category;
import com.inn.ecommerce.repo.CategoryRepo;


@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	public void deleteCategoryById(int id) {
		categoryRepo.deleteById(id);
	}
	public Optional<Category> getCategoryById(int id) {
		return categoryRepo.findById(id);
	}
}
