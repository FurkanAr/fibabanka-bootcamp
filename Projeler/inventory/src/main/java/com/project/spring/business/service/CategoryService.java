package com.project.spring.business.service;

import java.util.List;

import com.project.spring.business.dto.CategoryDto;

// Business evresinin gerçekleştiği kısım.
public interface CategoryService {
	
	List<CategoryDto> findAll();
	

}
