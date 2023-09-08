package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSellerDTO;
import com.devsuperior.dsmeta.projections.SaleSellerProjection;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {


	@Autowired
	private SaleService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleSellerDTO> findById(@PathVariable Long id) {
		SaleSellerDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleSellerDTO>> searchReport(@RequestParam(name = "minDate", defaultValue = "") String minDate,
	        @RequestParam(name = "maxDate", defaultValue = "") String maxDate,
	        @RequestParam(name = "name", defaultValue = "") String name ,
	        Pageable pageable){
		
	
		
		Page<SaleSellerDTO> dto = service.searchReport(minDate, maxDate, name, pageable);
		
		
		
		
		
		return ResponseEntity.ok(dto);
	}
	
	
	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SaleMinDTO>> search1(@RequestParam(name = "minDate", defaultValue = "") String minDate,
	        @RequestParam(name = "maxDate", defaultValue = "") String maxDate,
	        Pageable pageable){
		
	
		
		Page<SaleMinDTO> dto = service.search1(minDate, maxDate, pageable);
		
		
		
		
		
		return ResponseEntity.ok(dto);
	}
	
	

	
}
