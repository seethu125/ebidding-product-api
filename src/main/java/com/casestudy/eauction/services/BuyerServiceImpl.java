package com.casestudy.eauction.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.eauction.configurations.activemq.JmsProducer;
import com.casestudy.eauction.entities.Buyer;
import com.casestudy.eauction.entities.Product;
import com.casestudy.eauction.repos.BuyerRepository;
import com.casestudy.eauction.repos.SellerRepository;

@Service
public class BuyerServiceImpl implements BuyerService {
	
	@Autowired
	SellerRepository sellerRepository;
	
	
	@Autowired
	BuyerRepository buyerRepository;
	@Autowired
	JmsProducer jmsProducer;

	@Override
	public Buyer updateBid(String productId, String buyerEmailId, String newBidAmount) {
		try {
			Product product = sellerRepository.findById(Integer.parseInt(productId)).get();
			if(product != null) {
				
			}
		}
		catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public Buyer placeBid(Buyer buyer) {
		jmsProducer.sendMessage(buyer);
		return buyerRepository.save(buyer);
	}

	@Override
	public List<Product> showAllProducts() {
		return sellerRepository.findAll();
	}

	
}
