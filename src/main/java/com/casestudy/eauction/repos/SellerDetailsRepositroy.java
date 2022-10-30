package com.casestudy.eauction.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.eauction.entities.Seller;

public interface SellerDetailsRepositroy extends JpaRepository<Seller, String>{

}
