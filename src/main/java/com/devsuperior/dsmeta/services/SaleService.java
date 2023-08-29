package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
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
    
	 @Transactional(readOnly = true)
	    public List<SaleMinDTO> findAll(String minDate, String maxDate, String name) {
		 	List<SaleMinDTO> result = repository.search1(minDate,maxDate, name);
	        return result.stream().map(sale -> new SaleMinDTO(sale.getId(),sale.getAmount(),sale.getDate())).collect(Collectors.toList());
	    }
}
