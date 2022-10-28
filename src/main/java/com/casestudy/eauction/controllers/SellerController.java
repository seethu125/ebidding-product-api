package com.casestudy.eauction.controllers;

import com.casestudy.eauction.configurations.security.roles.IsSeller;
import com.casestudy.eauction.configurations.security.roles.IsSuper;
import com.casestudy.eauction.entities.Bid;
import com.casestudy.eauction.services.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/e-auction/api/v1/seller")
public class SellerController {

    Logger logger = LoggerFactory.getLogger(SellerController.class);

    @Autowired
    SellerService sellerService;
    
    @GetMapping(value={"/show-bids","/show-bids/{id}"})
    public List<Bid> showAllBids(@PathVariable(required = false) String id) {
        int bidId = 0;
        try {
             bidId = Integer.parseInt(id);
        }
        catch(Exception e) {
            logger.info("BidId is not there or not in correct format. BidId: "+ id );
        }
        return sellerService.showAllBids(bidId);
    }
    
    @PostMapping(value="/add-product")
    public Bid addProduct(@RequestBody Bid bid) {
    	return sellerService.addProduct(bid);
    }


}
