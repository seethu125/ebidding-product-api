package com.casestudy.eauction.repos;

import com.casestudy.eauction.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepository extends JpaRepository<Product,Integer> {
	
	@Query("select p from Product p where sellerEmail = ?1")
	public List<Product> findAllProductsBySellerEmail(String emailId);
}
