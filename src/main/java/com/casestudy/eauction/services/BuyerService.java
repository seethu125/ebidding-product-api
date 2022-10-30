package com.casestudy.eauction.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.casestudy.eauction.entities.Buyer;
import com.casestudy.eauction.entities.Product;

public interface BuyerService {




	Buyer placeBid(Buyer buyer);


	Page<Product> showAllProducts();


	List<Buyer> showALlBids();

}
