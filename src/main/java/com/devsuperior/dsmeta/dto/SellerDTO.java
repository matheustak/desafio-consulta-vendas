package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SellerDTO {
	private Long id;
	private String name;
	private String email;
	private String phone;
	private LocalDate date;
	private Double amount;
	
	public SellerDTO(Long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
	public SellerDTO(Sale entity) {
			this.id = entity.getSeller().getId();
			this.date = entity.getDate();
			this.amount = entity.getAmount();
			this.name = entity.getSeller().getName();
			
			
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


	public LocalDate getDate() {
		return date;
	}


	public Double getAmount() {
		return amount;
	}

	
	

}
