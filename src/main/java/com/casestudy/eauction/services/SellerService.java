package com.casestudy.eauction.services;

import com.casestudy.eauction.entities.Bid;

import java.util.List;

public interface SellerService {
    List<Bid> showAllBids(int id);

	Bid addProduct(Bid bid);
}
