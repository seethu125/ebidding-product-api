package com.casestudy.eauction.services;

import com.casestudy.eauction.entities.Buyer;
import com.casestudy.eauction.entities.Product;
import com.casestudy.eauction.entities.Seller;

import java.util.List;

public interface SellerService {
    List<Buyer> showAllBids(String email, int bidId);

	Product addProduct(Product bid);
	List<Product> showAllProducts(String emailId);

	Seller findSellerDetails(String email);

	Seller saveSellerDetails(Seller seller);
}
