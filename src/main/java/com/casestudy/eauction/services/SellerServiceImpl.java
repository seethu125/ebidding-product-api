package com.casestudy.eauction.services;

import com.casestudy.eauction.entities.Buyer;
import com.casestudy.eauction.entities.Product;
import com.casestudy.eauction.entities.Seller;
import com.casestudy.eauction.repos.BuyerRepository;
import com.casestudy.eauction.repos.SellerDetailsRepositroy;
import com.casestudy.eauction.repos.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;
    
    @Autowired
    SellerDetailsRepositroy sellerDetailsRepository;;
    
    @Autowired
    BuyerRepository buyerRepository;

    @Override
    public List<Product> showAllProducts(String emailId) {
        return sellerRepository.findAllProductsBySellerEmail(emailId);
    }

	@Override
	public Product addProduct(Product bid) {
		return sellerRepository.save(bid);
	}

	@Override
	public List<Buyer> showAllBids(String emailId,int productId) {		
		List<Product> products = sellerRepository.findAllProductsBySellerEmail(emailId);
		int newProductId = products.stream().map(Product::getProductId).filter(x-> x==productId).findAny().orElse(0);
		if(newProductId>0) {
			return buyerRepository.findAllBidsByProductId(productId);
		}
		return new ArrayList<>();		
		
	}

	@Override
	public Seller findSellerDetails(String email) {
		 Seller seller =  sellerDetailsRepository.findById(email).orElse(null);
		 if (Objects.isNull(seller)) {
			 seller = new Seller();
			 seller.setEmailId(email);
			 return sellerDetailsRepository.save(seller);
		 }
		 return seller;
	}

	@Override
	public Seller saveSellerDetails(Seller seller) {
		return sellerDetailsRepository.save(seller);
	}

	
}
