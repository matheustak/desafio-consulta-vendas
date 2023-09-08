package com.devsuperior.dsmeta.dto;

public class SaleMinDTO  {
	
	private String sellerName;
	private Double totalAmount;
	
	
	
	
	public SaleMinDTO(String sellerName, Double totalAmount) {
		super();
		this.sellerName = sellerName;
		this.totalAmount = totalAmount;
	}

	
	

	public String getSellerName() {
		return sellerName;
	}



	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}



	public Double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
	
}