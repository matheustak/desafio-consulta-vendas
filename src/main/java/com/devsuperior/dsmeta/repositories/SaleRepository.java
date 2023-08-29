package com.devsuperior.dsmeta.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT s FROM Sale s " +
	           "WHERE (:minDate IS NULL OR s.date >= :minDate) " +
	           "AND (:maxDate IS NULL OR s.date <= :maxDate) " +
	           "AND (:name IS NULL OR s.seller.name = :name)")
	List<SaleMinDTO> search1(@Param("minDate") String minDate,
								@Param("maxDate") String maxDate,
									@Param("name") String name);

	
}
