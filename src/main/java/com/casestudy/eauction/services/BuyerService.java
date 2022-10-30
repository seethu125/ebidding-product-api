package com.casestudy.eauction.services;

import java.util.List;

import com.casestudy.eauction.entities.Buyer;
import com.casestudy.eauction.entities.Product;

public interface BuyerService {


	Buyer updateBid(String productId, String buyerEmailId, String newBidAmount);


	Buyer placeBid(Buyer buyer);


	List<Product> showAllProducts();

}
