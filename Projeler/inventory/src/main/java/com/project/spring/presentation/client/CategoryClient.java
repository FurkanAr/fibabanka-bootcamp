package com.project.spring.presentation.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.spring.business.dto.CategoryDto;

// Client tarafının göreceği bilgiler..
@Component
public class CategoryClient {
	public List<CategoryDto> getCategories() {
		String url= "http://localhost:8081/inventory/categories/";
		RestTemplate restTemplate = new RestTemplate();
		List<CategoryDto> categoryDto =  restTemplate.getForObject(url, ArrayList.class);
		return categoryDto;
	}
}
