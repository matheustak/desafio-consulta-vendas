package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSellerDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
	
	
	  public Page<Sale> searchReport(String minDateStr, String maxDateStr, String name,Pageable pageable) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate minDate = LocalDate.parse(minDateStr, formatter);
		 LocalDate maxDate = LocalDate.parse(maxDateStr, formatter);
		
		 
	
		
		
		return repository.searchReport(minDate, maxDate, name, pageable);
		  
	 }
	 
	 
	

		 
}
