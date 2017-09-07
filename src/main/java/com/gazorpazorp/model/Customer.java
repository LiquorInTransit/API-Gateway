package com.gazorpazorp.model;

public class Customer {

	private Long id;
	private Long userId;
	private String address;
	private String paymentMethod;
	
	public Customer() {}
	

	public Customer(Long userId) {
		super();
		this.userId = userId;
	}


	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
