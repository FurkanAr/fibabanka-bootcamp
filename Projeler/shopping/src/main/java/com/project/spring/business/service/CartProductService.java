package com.project.spring.business.service;

//Business evresinin gerçekleştiği kısım.
import java.util.List;

import com.project.spring.business.dto.CartProductDto;

public interface CartProductService {

	CartProductDto create(CartProductDto cartProductDto);
	List<CartProductDto> getCartProductsByCart(long cartId);

	
}
