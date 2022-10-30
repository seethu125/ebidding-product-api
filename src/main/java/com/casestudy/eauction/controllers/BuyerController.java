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
import com.casestudy.eauction.services.BuyerService;

@RestController
@RequestMapping("/e-auction/api/v1/buyer")
public class BuyerController {

    Logger logger = LoggerFactory.getLogger(SellerController.class);

    @Autowired
    BuyerService buyerService;
    
    @PutMapping(value="/update-bid/{productId}/buyerEnailId/{newBidAmount}")
    public Buyer updateBid(@PathVariable String productId,@PathVariable String buyerEmailId,@PathVariable String newBidAmount){
    	return buyerService.updateBid(productId,buyerEmailId,newBidAmount);
    }
    
    @GetMapping(value={"/show-products"})
	public List<Product> showProducts() {
		
		return buyerService.showAllProducts();
	}
    
    @PostMapping(value="/place-bid")
    public Buyer placeBid(@RequestBody Buyer buyer){
    	return buyerService.placeBid(buyer);
    }
    
   
}
