package com.project.spring.business.service;


//dışarıyla olan bağlantı ile gelen dtolar ile gerekli işlemler yapılır. (Dto -> entity, entity -> Dto)
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.spring.business.dto.CartProductDto;
import com.project.spring.data.entity.CartProduct;
import com.project.spring.data.repository.CartProductRepository;

@Service
public class CartProductServiceImpl implements CartProductService{

	private CartProductRepository cartProductRepository;
	
	public CartProductServiceImpl(CartProductRepository cartProductRepository) {
		this.cartProductRepository = cartProductRepository;
	}
	// Kart Ürün nesnesi oluşturulur..
	@Override
	public CartProductDto create(CartProductDto cartProductDto) {
		CartProduct cartProduct = new CartProduct();
		cartProduct.setLineAmount(cartProductDto.getLineAmount());
		cartProduct.setProductId(cartProductDto.getProductId());
		cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
		cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
		cartProduct.setCart(cartProductDto.getCart());
		cartProductRepository.save(cartProduct);
		return cartProductDto;
	}
	
	// Kart ürünleri istenen spesifik karta göre listelenir..
	public List<CartProductDto> getCartProductsByCart(long cartId){
		List<CartProductDto> cartProductDtos = new ArrayList<>();
		Iterable<CartProduct> products = cartProductRepository.findAllByCartId(cartId);
		for (CartProduct product:products) {
			CartProductDto cartProductDto = new CartProductDto();
			cartProductDto.setCartProductId(product.getCartProductId());
			cartProductDto.setLineAmount(product.getLineAmount());
			cartProductDto.setProductId(product.getProductId());
			cartProductDto.setSalesPrice(product.getSalesPrice());
			cartProductDto.setSalesQuantity(product.getSalesQuantity());
			cartProductDto.setCart(product.getCart());
			cartProductDtos.add(cartProductDto);
		}
		return cartProductDtos;
	}



}
