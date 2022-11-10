package com.project.spring.business.service;
//Business evresinin gerçekleştiği kısım.
import java.util.List;

import com.project.spring.business.dto.CartDto;
import com.project.spring.data.entity.Cart;

public interface CartService {
	
	Cart createCart(CartDto cartDto);
	
	CartDto checkout (long cartId);
	
	CartDto find (long cartId);
	
	List<CartDto> findAll();
	
	



}
