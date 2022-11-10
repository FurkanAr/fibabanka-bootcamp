package com.godoro.spring.presentation.mvc;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.godoro.spring.data.entity.Product;
import com.godoro.spring.data.repository.ProductRepository;

@Controller
@RequestMapping("/inventory")
public class ProductController {

	//@Autowired
	private ProductRepository productRepository;
	
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/product/insert")
	@ResponseBody
	public String insertProduct() {
		Product product = new Product(6, "Televizyon", 5430);
		productRepository.save(product);
		return "Sokuldu : " + product.getProductId();
	}
	
	@GetMapping("/product/find")
	@ResponseBody
	public String findProduct() {
		long productId=3;
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			System.out.println(product.getProductId()+ " "
					+product.getProductName()+ " "
					+product.getSalesPrice());
			return "Ürün bulundu : " + product.getProductName();
		}
		return "Ürün bulunamadı..";
	}
	
	@GetMapping("/product/list")
	@ResponseBody
	public String listProducts() {
		Iterable<Product> products = productRepository.findAll();
		int count=0;
		for (Product product: products) {
			System.out.println(product.getProductId()+ " "
					+product.getProductName()+ " "
					+product.getSalesPrice());
			count++;
		}
		return "Ürün sayısı: " +count;
	}
	
	
	@GetMapping("/product/expensives")
	@ResponseBody
	public String listExpensiveProducts() {
		double minPrice=4000;
		Iterable<Product> products = productRepository.findAllBySalesPriceMin(minPrice);
		int count=0;
		for (Product product: products) {
			System.out.println(product.getProductId()+ " "
					+product.getProductName()+ " "
					+product.getSalesPrice());
			count++;
		}
		return "Ürün sayısı: " +count;
	}
	
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		long productId=10;
		if (!productRepository.existsById(productId)) {
			return "Bulunamadı.. " + productId;
		}
		productRepository.deleteById(productId);
		return "Silindi..";
	}
}
