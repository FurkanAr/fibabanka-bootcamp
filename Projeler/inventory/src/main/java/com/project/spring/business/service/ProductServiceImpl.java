package com.project.spring.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.spring.business.dto.ProductDto;
import com.project.spring.data.entity.Product;
import com.project.spring.data.repository.ProductRepository;
//dışarıyla olan bağlantı ile gelen dtolar ile gerekli işlemler yapılır. (Dto -> entity, entity -> Dto)
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
		

	// Id bilgisi verilen ürün geri döndürülür. 
	@Override
	public ProductDto find(long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setSalesPrice(product.getSalesPrice());
			productDto.setCategory(product.getCategory());
			return productDto;

		}
		return null;	
	}
	
	// Veritabanındaki bütün veriler geri döndürülür. 
	@Override
	public List<ProductDto> findAll() {
		List<ProductDto> productDtos = new ArrayList<>();
		Iterable<Product> products = productRepository.findAll();
		for (Product product: products) {
			ProductDto productDto = new ProductDto();
			productDto.setProductName(product.getProductName());
			productDto.setSalesPrice(product.getSalesPrice());
			productDto.setCategory(product.getCategory());
			productDtos.add(productDto);
		}
		return productDtos;
	}
	
	// Ürünleri istenen kategoriye göre listeler.
	public List<ProductDto>  getProductsByCategory(long categoryId) {
		List<ProductDto> productDtos = new ArrayList<>();
		Iterable<Product> products = productRepository.findAllByCategoryId(categoryId);
		for (Product product: products) {
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setSalesPrice(product.getSalesPrice());
			productDto.setCategory(product.getCategory());
			productDtos.add(productDto);
		}
		return productDtos;
		
	}



}
