package com.project.spring.presentation.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.spring.business.dto.ProductDto;

//Client tarafının göreceği bilgiler..
@Component
public class ProductClient {
	
	public ProductDto getProduct(long productId) {
		String url= "http://localhost:8081/inventory/product/"+productId;
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}
	
	public List<ProductDto> getProducts(long categoryId) {
		String url= "http://localhost:8081/inventory/products/"+categoryId;
		RestTemplate restTemplate = new RestTemplate();
		List<ProductDto> productDto = restTemplate.getForObject(url, ArrayList.class);
		return productDto;
	}

}
