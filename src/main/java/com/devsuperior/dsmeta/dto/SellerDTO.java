package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;

public class SellerDTO {
	private Long id;
	private String name;
	private String email;
	private String phone;
	
	
	public SellerDTO(Long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
	public SellerDTO(Seller entity) {
		this.name = entity.getName();
	}
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}

	
	

}
