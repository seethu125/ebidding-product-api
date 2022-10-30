package com.casestudy.eauction.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.eauction.configurations.security.models.User;
import com.casestudy.eauction.entities.Buyer;
import com.casestudy.eauction.entities.Product;
import com.casestudy.eauction.entities.Seller;
import com.casestudy.eauction.services.SellerService;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class SellerController {

	Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	SellerService sellerService;

	@GetMapping(value={"/show-bids","/show-bids/{id}"})
	public List<Buyer> showAllBids(@PathVariable(required = false) String id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object pricipal = auth.getPrincipal();
		String email="";
		if (pricipal instanceof User) {
			email = ((User) pricipal).getEmail();
		}
		int bidId = 0;
		try {
			bidId = Integer.parseInt(id);
		}
		catch(Exception e) {
			logger.info("BidId is not there or not in correct format. BidId: "+ id );
		}
		return sellerService.showAllBids(email,bidId);
	}

	@GetMapping(value={"/show-products"})
	public List<Product> showProducts() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object pricipal = auth.getPrincipal();
		String email="";
		if (pricipal instanceof User) {
			email = ((User) pricipal).getEmail();
		}
		return sellerService.showAllProducts(email);
	}

	@PostMapping(value="/add-product")
	public Product addProduct(@RequestBody Product bid) {
		return sellerService.addProduct(bid);
	}

	@GetMapping(value="/user/details") 
	public Seller getSellerDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object pricipal = auth.getPrincipal();
		String email="";
		if (pricipal instanceof User) {
			email = ((User) pricipal).getEmail();
		}
		return sellerService.findSellerDetails(email);    
	}
	
	@PutMapping(value="/user/details/save") 
	public Seller saveSellerDetails(@RequestBody Seller seller) {
		
		return sellerService.saveSellerDetails(seller);    
	}


}
