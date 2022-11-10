package com.project.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.spring.data.entity.Cart;

//Create, read, update, delete işlemlerinin yapılmasını sağlayan interface implement edilir. 
public interface CartRepository  extends CrudRepository<Cart, Long> {
}
