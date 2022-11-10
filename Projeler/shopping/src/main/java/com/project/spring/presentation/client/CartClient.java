package com.project.spring.presentation.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.project.spring.business.dto.CartDto;


//Client tarafının göreceği bilgiler..
@Controller
public class CartClient {
	
	// Kart yaratma kısmında kullanıcının göreceği bilgiler..
	@GetMapping("/shopping/cart/get/")
	@ResponseBody
	public String getCart() {
		String url= "http://localhost:8082/shopping/cart/create/";
		RestTemplate restTemplate = new RestTemplate();
		long cartId = restTemplate.getForObject(url, long.class);
		if(cartId != 0) {
			System.out.println("Kart: " + cartId);
			return "Kart id: "+ cartId;
		}
		return "Kart eklenemedi...";

	}
	// İstenen kartın statüsü görüntülenir..
	@GetMapping("/shopping/cart/checkout/")
	@ResponseBody
	public String getStatus() {
		long cartId = 8;
		String url= "http://localhost:8082/shopping/checkout/"+cartId;
		RestTemplate restTemplate = new RestTemplate();
		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);
		if (cartDto != null) {
		System.out.println(cartDto.getCartStatus());
		return "Kart sahibi: "+ cartDto.getCustomerName() + " Kart statüsü: " + cartDto.getCartStatus() + " Kart id: "+ cartDto.getCartId();
		}
		return "Kart bulunamadı..";
	
	}
	//Kartın sistemde olup olmadığı kontrol edilir..
	@GetMapping("/shopping/cart/check/")
	@ResponseBody
	public String getCartDto() {
		String url= "http://localhost:8082/shopping/cart/find/";
		RestTemplate restTemplate = new RestTemplate();
		CartDto cart = restTemplate.getForObject(url, CartDto.class);
		if(cart != null) {
			System.out.println("Kart: " + cart.getCartId() + " " + cart.getCustomerName());
			return "Kart id: "+ cart.getCartId()  + " Kart Sahibi: " + cart.getCustomerName();
		}
		return "KartDto bulunamadı...";

	}
	
}
