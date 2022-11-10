package com.project.spring.business.dto;
//Cart Dto, Dışardan kart bilgilerini dto olarak almamız gerekiyor. Verilere dışardan erişimi engelliyoruz 
public class CartDto {
	
	private long cartId;
	private String customerName;
	private double totalAmount;
	private int cartStatus;

	
	public CartDto() {
	}

	public CartDto(long cartId, String customerName, double totalAmount, int cartStatus) {
		this.cartId = cartId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;

	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(int cartStatus) {
		this.cartStatus = cartStatus;
	}
	
	
	
	
}
