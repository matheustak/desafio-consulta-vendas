package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSellerDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleSellerProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	

	
	public SaleSellerDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleSellerDTO(entity);
	}
	
	
	  public Page<SaleSellerDTO> searchReport(String minDateStr, String maxDateStr, String name,Pageable pageable) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate minDate = LocalDate.parse(minDateStr, formatter);
		 LocalDate maxDate = LocalDate.parse(maxDateStr, formatter);
		
		 
		 
		Page<Sale> entity = repository.searchReport(minDate, maxDate, name, pageable);
		
		Page<SaleSellerDTO> dto = entity.map(x->new SaleSellerDTO(x));
		return dto;

		  
	 }
	 
	 
	 
	  

	  public Page<SaleMinDTO> search1(String minDateStr, String maxDateStr,Pageable pageable) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate minDate = LocalDate.parse(minDateStr, formatter);
		 LocalDate maxDate = LocalDate.parse(maxDateStr, formatter);
		
		 
		 
		 Page<SaleSellerProjection> entity = repository.search1(minDate, maxDate, pageable);
		
		
		Page<SaleMinDTO> dto = entity.map(x-> new SaleMinDTO(x.getsellerName(),x.gettotalAmount()));
		return dto;
	
		
	 }
	 
	

		 
}
