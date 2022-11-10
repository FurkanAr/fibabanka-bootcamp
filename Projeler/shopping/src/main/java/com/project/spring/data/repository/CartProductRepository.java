package com.project.spring.data.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.spring.data.entity.CartProduct;

//Create, read, update, delete işlemlerinin yapılmasını sağlayan interface implement edilir. 
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
	@Query("select cp from CartProduct cp where cp.cart.cartId = :cartId")
	List<CartProduct> findAllByCartId(@Param("cartId") long cartId);

}
