package com.project.spring.business.dto;

//ProductDto Dto, Dışardan ürün bilgilerini dto olarak almamız gerekiyor. Verilere dışardan erişimi engelliyoruz 
import com.project.spring.data.entity.Category;

public class ProductDto {
	
	private long productId;
	private String productName;
	private double salesPrice;
	
	private Category category;

	
	public ProductDto() {
	}
	
	public ProductDto(long productId, String productName, double salesPrice) {
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}





	
	
}
