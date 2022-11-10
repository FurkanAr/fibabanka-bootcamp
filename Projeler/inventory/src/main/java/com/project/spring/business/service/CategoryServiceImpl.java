package com.project.spring.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.spring.business.dto.CategoryDto;
import com.project.spring.data.entity.Category;
import com.project.spring.data.repository.CategoryRepository;
// dışarıyla olan bağlantı ile gelen dtolar ile gerekli işlemler yapılır. (Dto -> entity, entity -> Dto)
@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	// Bütün kategorileri listeler..
	@Override
	public List<CategoryDto> findAll() {
		List<CategoryDto> categoryDtos = new ArrayList<>();
		Iterable<Category> categories = categoryRepository.findAll();
		for (Category category:categories) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setCategoryId(category.getCategoryId());
			categoryDto.setCategoryName(category.getCategoryName());
			categoryDtos.add(categoryDto);
		}
		return categoryDtos;
	}



}
