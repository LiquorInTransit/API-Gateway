package com.gazorpazorp.model;

public class Driver {

	private Long id;
	private Long userId;
	private String car;
	
	public Driver() {}
	public Driver(Long userId) {
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

	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	
	
}
