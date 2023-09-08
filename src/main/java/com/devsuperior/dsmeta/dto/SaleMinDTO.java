package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleMinDTO  {
	
	private String name;
	private Double amount;
	
	public SaleMinDTO(String name, Double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	
	
	public SaleMinDTO(Sale entity) {
		super();
		name = entity.getSeller().getName();
		amount = entity.getAmount();
	}
	
	

	public String getName() {
		return name;
	}

	public Double getAmount() {
		return amount;
	}
	
	
	
	

	
}