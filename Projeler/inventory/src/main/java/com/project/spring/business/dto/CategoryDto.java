package com.project.spring.business.dto;
// Category Dto, Dışardan kategori bilgilerini dto olarak almamız gerekiyor. Verilere dışardan erişimi engelliyoruz 
public class CategoryDto {
	
	private long categoryId;
	private String categoryName;
	
	public CategoryDto() {
	}

	public CategoryDto(long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	



	
	
	
	
	

}
