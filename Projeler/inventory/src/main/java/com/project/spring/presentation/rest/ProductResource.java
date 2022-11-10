package com.project.spring.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.business.dto.CategoryDto;
import com.project.spring.business.dto.ProductDto;
import com.project.spring.business.service.CategoryService;
import com.project.spring.business.service.ProductService;

// Rest servisi gelen isteklere cevap verir. 
@RestController
public class ProductResource {

	
	private ProductService productService;
	private CategoryService categoryService;

	public ProductResource(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	// kullanıcının verdiği id bilgisine göre ilgili ürünü geri döndürür.
	@GetMapping("/inventory/product/{id}")
	public ProductDto getProduct(@PathVariable("id")long productId) {
		ProductDto product = productService.find(productId);
		return product;
	}
	
	@GetMapping("/inventory/products/{id}")
	public List<ProductDto> getProducts(@PathVariable("id")long categoryId) {
		List<ProductDto> products = productService.getProductsByCategory(categoryId);
		if (products.isEmpty())
			return null;
		return products;
	}
	
	@GetMapping("/inventory/categories/")
	public List<CategoryDto> getCategories() {
		List<CategoryDto> categoryDtos = categoryService.findAll();
		return categoryDtos;
	}
	
	

}
