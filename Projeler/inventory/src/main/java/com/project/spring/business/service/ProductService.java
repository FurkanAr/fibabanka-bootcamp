package com.project.spring.business.service;

import java.util.List;

import com.project.spring.business.dto.ProductDto;

//Business evresinin gerçekleştiği kısım.
public interface ProductService {
	
	List<ProductDto> getProductsByCategory(long categoryId);
	ProductDto find(long productId);
	List<ProductDto> findAll();
	

}
