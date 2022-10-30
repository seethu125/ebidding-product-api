package com.casestudy.eauction.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.casestudy.eauction.entities.Buyer;

public interface BuyerRepository  extends JpaRepository<Buyer,Integer> {

	@Query("select b from Buyer b where productId = ?1")
	public List<Buyer> findAllBidsByProductId(int productId);
}

