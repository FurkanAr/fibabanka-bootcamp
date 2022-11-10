package com.project.spring.presentation.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.project.spring.business.dto.CartProductDto;

@Controller
public class CartProductClient {
	
	// Oluşan kart ürünü
	@GetMapping("/shopping/cart/post")
	@ResponseBody
	public String addProduct() {
		CartProductDto cartProductDto = new CartProductDto(1, 1, 3, 100, 300);
		String url= "http://localhost:8082/shopping/cart/add/";
		RestTemplate restTemplate = new RestTemplate();
		CartProductDto result = restTemplate.postForObject(url, cartProductDto, CartProductDto.class);
		System.out.print(result.getCartProductId() + " " + result.getCart() + " "+
		result.getLineAmount() + " " + result.getSalesPrice()+ " " +result.getSalesQuantity()+ " "+
		result.getProductId());
		return "Yollama başarılı "+ result.getCartProductId();
	}
	



}
