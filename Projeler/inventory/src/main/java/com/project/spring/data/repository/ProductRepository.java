package com.project.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.spring.data.entity.Product;
//Create, read, update, delete işlemlerinin yapılmasını sağlayan interface implement edilir. 
public interface ProductRepository  extends CrudRepository<Product, Long> {
	@Query("select p from Product p where p.category.categoryId = :categoryId")
	List<Product> findAllByCategoryId(@Param("categoryId") long categoryId);
	
}
