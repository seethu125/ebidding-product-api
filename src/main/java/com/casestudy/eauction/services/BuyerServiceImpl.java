package com.casestudy.eauction.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.casestudy.eauction.configurations.activemq.JmsProducer;
import com.casestudy.eauction.configurations.security.models.User;
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
	public Buyer placeBid(Buyer buyer) {
		jmsProducer.sendMessage(buyer);
		return buyerRepository.save(buyer);
	}

	@Override
	public Page<Product> showAllProducts() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 50);
		return  sellerRepository.findAll(firstPageWithTwoElements);
	}

	@Override
	public List<Buyer> showALlBids() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object pricipal = auth.getPrincipal();
		String email="";
		if (pricipal instanceof User) {
			email = ((User) pricipal).getEmail();
		}		
		return buyerRepository.findAllBidsByEmail(email);
	}

	
}
