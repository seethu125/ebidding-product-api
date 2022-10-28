package com.casestudy.eauction.services;

import com.casestudy.eauction.entities.Bid;
import com.casestudy.eauction.repos.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public List<Bid> showAllBids(int id) {
        if(id>0) {
            List<Bid> list = new ArrayList<>();
            sellerRepository.findById(id).ifPresent(b->list.add(b));
            return list;

        }
        return sellerRepository.findAll();
    }

	@Override
	public Bid addProduct(Bid bid) {
		return sellerRepository.save(bid);
	}
}
