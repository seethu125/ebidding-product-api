package com.casestudy.eauction.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.casestudy.eauction.entities.Buyer;
import com.casestudy.eauction.entities.BuyerKey;


public interface BuyerRepository  extends JpaRepository<Buyer,BuyerKey> {

	@Query("select b from Buyer b where product_id = ?1")
	public List<Buyer> findAllBidsByProductId(int productId);

	@Query("select b from Buyer b where buyer_email_id = ?1")
	public List<Buyer> findAllBidsByEmail(String email);
}

