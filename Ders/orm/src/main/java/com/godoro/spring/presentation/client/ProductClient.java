package com.godoro.spring.presentation.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.godoro.spring.business.dto.ProductDto;

@Component
public class ProductClient {

	public ProductDto getProduct(long productId) {
		String url= "http://localhost:8090/api/product/"+productId;
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}
	
	@GetMapping("/product/post")
	@ResponseBody
	public String postProduct() {
		ProductDto productDto = new ProductDto(0, "Fritöz", 540);
		String url= "http://localhost:8090/api/product/";
		RestTemplate restTemplate = new RestTemplate();
		ProductDto result = restTemplate.postForObject(url, productDto , ProductDto.class);
		return "Yollama Başarılı "+ result.getProductId();
	}
	
	@GetMapping("/product/put")
	@ResponseBody
	public String putProduct() {
		ProductDto productDto = new ProductDto(302, "Tablet Bilgisayar", 5465);
		String url= "http://localhost:8090/api/product/";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT , new HttpEntity<ProductDto>(productDto), Void.class);
		return "Koyma Başarılı";
	}
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		long productId=303;
		String url= "http://localhost:8090/api/product/"+productId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme Başarılı ";
	}
}
