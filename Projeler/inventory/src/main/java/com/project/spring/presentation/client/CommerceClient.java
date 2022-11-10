package com.project.spring.presentation.client;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.spring.business.dto.CategoryDto;
import com.project.spring.business.dto.ProductDto;
// Ana client içerdiği ürün ve kategori arayüzleri sayesinde kullanıcıyla etkilişime giren sınıf(client)..
@Controller
@RequestMapping("/inventory")
public class CommerceClient {

	@Autowired
	private ProductClient productClient;
	
	@Autowired 
	private CategoryClient categoryClient;
	
	@GetMapping("/product/get")
	@ResponseBody
	public String getProduct() {
		long productId=1;
		ProductDto product = productClient.getProduct(productId);
		if(product != null) {
			System.out.println("Ürün: " +product.getProductName()+" "+ product.getSalesPrice() + product.getCategory().getCategoryName());
			return product.getProductName()+ product.getCategory();
		}
		return null;
		
	}
	
	@GetMapping("/product/category/get")
	@ResponseBody
	public List<ProductDto> getProducts() {
		long categoryId=2;
		List<ProductDto> products= productClient.getProducts(categoryId);
		if(products != null) {
			System.out.println("Ürün: " +products);
			return products;
		}
		return null;
		
	}
	
	
	
	@GetMapping("/category/get")
	@ResponseBody
	public List<CategoryDto>  getCategory() {
		List<CategoryDto> categories = categoryClient.getCategories();
		if(categories != null) {
			System.out.print("Kategoriler: " + categories);
			return categories;
		}
		
		return null;
		
	}
	
}
