package com.casestudy.eauction.repos;

import com.casestudy.eauction.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Bid,Integer> {
}
