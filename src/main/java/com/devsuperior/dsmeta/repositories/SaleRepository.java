package com.devsuperior.dsmeta.repositories;



import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleSellerProjection;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	

	@Query(nativeQuery= true,value = "SELECT s.name AS sellerName, SUM(sale.amount) AS totalAmount "
			+ "FROM tb_sales sale "
			+ "JOIN tb_seller s ON sale.seller_id = s.id "
			+ "WHERE sale.date >=:minDate AND sale.date <=:maxDate "
			+ "GROUP BY s.name",
	countQuery ="SELECT s.name AS sellerName, SUM(sale.amount) AS totalAmount "
			+ "FROM tb_sales sale "
			+ "JOIN tb_seller s ON sale.seller_id = s.id "
			+ "WHERE sale.date >=: minDate AND sale.date <=: maxDate "
			+ "GROUP BY s.name")
	Page<SaleSellerProjection>search1(LocalDate minDate,
		       LocalDate maxDate, 
		       Pageable pageable);
	
	
	
	
	
	
	
	
	@Query(value = "SELECT obj FROM Sale obj JOIN FETCH obj.seller seller " +
			"WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
			"AND obj.date >= :minDate AND obj.date <= :maxDate ORDER BY obj.date ASC",
			countQuery = "SELECT COUNT(obj) FROM Sale obj JOIN obj.seller seller " +
					"WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
					"AND obj.date >= :minDate AND obj.date <= :maxDate")
				
	/*@Query(value = "SELECT obj "
            + "FROM Sale obj "
            + "JOIN FETCH obj.seller "
            + "WHERE obj.date BETWEEN :minDate AND :maxDate "
            + "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) ",
            countQuery = "SELECT COUNT(obj) "
                    + "FROM Sale obj "
                    + "WHERE obj.date BETWEEN :minDate AND :maxDate "
                    + "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")*/
   
	
	Page<Sale>searchReport(LocalDate minDate,
	       LocalDate maxDate,
	       String name,
	        Pageable pageable
	      );
	
	
	
}
