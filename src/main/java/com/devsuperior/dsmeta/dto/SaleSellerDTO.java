package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SaleSellerDTO {
	private Long id;
	private Double amount;
	private LocalDate date;
	private String name;
	
	private Seller seller;


	public SaleSellerDTO(Long id, Double amount, LocalDate date, Seller seller) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}
	
	
	public SaleSellerDTO(Sale entity) {
		this.id = entity.getId();
		this.amount = entity.getAmount();
		this.date = entity.getDate();
		this.name = entity.getSeller().getName();
	}
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}


	public String getName() {
		return name;
	}
	
	
	
}
