package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	 public List<SaleSellerDTO> searchReport(String minDate, String maxDate, String name,Pageable pageable) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 LocalDate min = LocalDate.parse(minDate, formatter);
		 LocalDate max = LocalDate.parse(maxDate, formatter);
	
		 	
		  		 	List<Sale> result = repository.searchReport(min,max,name,pageable);
		  		 	
		  		 	return result.stream().map(Sale -> new SaleSellerDTO(Sale)).collect(Collectors.toList());
		  
	 }

		 
}
