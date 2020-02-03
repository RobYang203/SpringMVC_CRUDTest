package com.test.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String address;
	
	protected Customer() {
		
	}
	
	protected Customer(String name,String email,String address) {
		this.name = name;
		this.address = address;
		this.email = email;		
	}
	
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address=address;
	}

}
