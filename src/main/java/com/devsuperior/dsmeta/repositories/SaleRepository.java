package com.devsuperior.dsmeta.repositories;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	

	//@Query(value = "SELECT obj FROM Seller obj JOIN FETCH obj.sales" )
	 // @Query("SELECT s, s.seller.name FROM Sale s JOIN FETCH s.seller")
	
	@Query( value ="SELECT obj FROM Sale obj JOIN FETCH obj.seller seller ",
			countQuery= "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller seller "
			+ " WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name , '%'))"
			+ " AND obj.date >=:minDate AND obj.date<=:maxDate ORDER BY obj.date ASC")
			
				
	
	List<Sale>searchReport(LocalDate minDate, LocalDate maxDate, String name,Pageable pageable);
	
}
