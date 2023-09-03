package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;

public class SaleSellerDTO {
	private Long id;
	private Double amount;
	private LocalDate date;
	private String sellerName;

	private SellerDTO sellerdto;

	public SaleSellerDTO(Long id, Double amount, LocalDate date , SellerDTO sellerdto) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.sellerdto = sellerdto;
	}
	
	
	public SaleSellerDTO(Sale entity) {
		this.id = entity.getId();
		this.amount = entity.getAmount();
		this.date = entity.getDate();
		this.sellerName = entity.getSeller().getName();
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
		return sellerName;
	}


	public SellerDTO getSellerdto() {
		return sellerdto;
	}
	
	
	
}
