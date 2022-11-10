package com.project.spring.presentation.rest;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.business.dto.CartDto;
import com.project.spring.business.dto.CartProductDto;
import com.project.spring.business.service.CartProductService;
import com.project.spring.business.service.CartService;
import com.project.spring.data.entity.Cart;

//Rest servisi gelen isteklere cevap verir. 
@RestController
public class CartResource {
	
	private CartService cartService;
	private CartProductService cartProductService;

	public CartResource(CartService cartService, CartProductService cartProductService) {
		this.cartService = cartService;
		this.cartProductService = cartProductService;
	}
	// Kart ve kart ürün nesnesi oluşturur kartın id bilgisini döndürür.
	@GetMapping("/shopping/cart/create/")
	public long createCart() {
		CartDto cartDto = new CartDto();
		Cart cart = cartService.createCart(cartDto);
		CartProductDto cartProductDto = new CartProductDto();
		cartDto.setCartId(cart.getCartId());
		cartProductDto.setCart(cart);
		CartProductDto cartPr = cartProductService.create(cartProductDto);
		cartProductDto.setCartProductId(cartPr.getCartProductId());	
		System.out.println(cartDto.getCartId()+ " "+ cartDto.getCustomerName());
		return cart.getCartId();
	}
	// İstenen kartın statüsünü değiştirir.
	@GetMapping("/shopping/checkout/{id}")
	public CartDto getStatus(@PathVariable("id") long cartId) {
		CartDto cart = cartService.checkout(cartId); 
		System.out.println(cart.getCartId()+ " "+ cart.getCustomerName());
		return cart;
	}
	// karta kart ürünü ekleme kısmı
	@PostMapping("/shopping/cart/add/")
	public CartProductDto postProduct(@RequestBody CartProductDto cartProductDto) {
		CartProductDto cartPr = cartProductService.create(cartProductDto);
		cartProductDto.setCartProductId(cartPr.getCartProductId());
		long cartId=13;
		List<CartProductDto> cartProducts = cartProductService.getCartProductsByCart(cartId);
		if (cartProducts.isEmpty())
			return null;
		for (CartProductDto cartProduct : cartProducts) {
			System.out.println("Kart: "+cartProduct.getCart().getCartId());
			System.out.println("Ürün kartno: "+cartProduct.getCartProductId());
			System.out.println("Ürün no: " +cartProduct.getProductId());
			System.out.println("Ürün fiyatı: "+cartProduct.getSalesPrice());
			System.out.println("Ürün miktarı:" +cartProduct.getSalesQuantity());
			System.out.println("Toplam fiyat:  "+cartProduct.getLineAmount());
		}
		System.out.println("Kart: " +cartProductDto.getCart());
		
		return cartProductDto;
	}
	
	// İstenen kartı veritabanından bulur
	@GetMapping("/shopping/cart/find/")
	public CartDto getCartDto() {
		long cartId=1;
		CartDto cart = cartService.find(cartId);
		System.out.println(cart.getCartId()+ " "+ cart.getCustomerName());
		return cart;
	}
	

	
	

	

}
