package com.project.spring.business.dto;
//CartProduct Dto, Dışardan CartProduct bilgilerini dto olarak almamız gerekiyor. Verilere dışardan erişimi engelliyoruz 
import com.project.spring.data.entity.Cart;

public class CartProductDto {
	
	private long cartProductId;
	private long productId;
	private int salesQuantity;
	private double salesPrice;
	private double lineAmount;
	private Cart cart;
	

	public CartProductDto() {
	}


	public CartProductDto(long cartProductId, long productId, int salesQuantity, double salesPrice, double lineAmount) {
		this.cartProductId = cartProductId;
		this.productId = productId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.lineAmount = lineAmount;
	}
	
	

	public long getCartProductId() {
		return cartProductId;
	}


	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public int getSalesQuantity() {
		return salesQuantity;
	}


	public void setSalesQuantity(int salesQuantity) {
		this.salesQuantity = salesQuantity;
	}


	public double getSalesPrice() {
		return salesPrice;
	}


	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}


	public double getLineAmount() {
		return lineAmount;
	}


	public void setLineAmount(double lineAmount) {
		this.lineAmount = lineAmount;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}



	


}
