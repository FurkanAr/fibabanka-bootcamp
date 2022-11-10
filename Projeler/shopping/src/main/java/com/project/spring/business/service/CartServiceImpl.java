package com.project.spring.business.service;

//dışarıyla olan bağlantı ile gelen dtolar ile gerekli işlemler yapılır. (Dto -> entity, entity -> Dto)
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.spring.business.dto.CartDto;
import com.project.spring.data.entity.Cart;
import com.project.spring.data.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	private CartRepository cartRepository;
	
	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	
	// Yeni bir kart yaratır..
	@Override
	public Cart createCart(CartDto cartDto) {
		Cart cart = new Cart();
		cart.setCartId(cartDto.getCartId());
		cart.setCustomerName(cartDto.getCustomerName());
		cart.setCartStatus(cartDto.getCartStatus());
		cart.setTotalAmount(cartDto.getTotalAmount());
		cartRepository.save(cart);
		return cart;
	}
	// Dışardan alınan kart id sayesinde kartın statüsü değiştirilir. 
	@Override
	public CartDto checkout(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		if (optional.isPresent()) {
			Cart cart = optional.get();
			CartDto cartDto = new CartDto();
			cartDto.setCustomerName(cart.getCustomerName());
			cartDto.setCartId(cart.getCartId());
			if (cart.getCartStatus() == 0) {
				cart.setCartStatus(1);
			}
			cartDto.setCartStatus(cart.getCartStatus());
			cartDto.setTotalAmount(cart.getTotalAmount());
			cartRepository.save(cart);
			return cartDto;
		}
		
		return null;
	}
	// İstenen kartın spesifik kart bulunur.
	@Override
	public CartDto find(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		if (optional.isPresent()) {
			Cart cart = optional.get();
			CartDto cartDto = new CartDto();
			cartDto.setCustomerName(cart.getCustomerName());
			cartDto.setCartId(cart.getCartId());
			cartDto.setCartStatus(cart.getCartStatus());
			cartDto.setTotalAmount(cart.getTotalAmount());
			return cartDto;
		}
		return null;

		}
	// Sistemde bulunan bütün kartlar döndürülür..
	@Override
	public List<CartDto> findAll() {
		List <CartDto> cartDtos = new ArrayList<>();
		Iterable <Cart> carts = cartRepository.findAll();
		for (Cart cart : carts) {
			CartDto cartDto = new CartDto();
			cartDto.setCartStatus(cart.getCartStatus());
			cartDto.setCustomerName(cart.getCustomerName());
			cartDto.setTotalAmount(cart.getTotalAmount());
			cartDtos.add(cartDto);
		}
		return cartDtos;
	}

	
}
