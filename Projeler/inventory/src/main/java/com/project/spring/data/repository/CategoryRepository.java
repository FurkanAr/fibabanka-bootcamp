package com.project.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.spring.data.entity.Category;

// Create, read, update, delete işlemlerinin yapılmasını sağlayan interface implement edilir. 
public interface CategoryRepository  extends CrudRepository<Category, Long> {

}
