package com.casestudy.eauction.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String productName;

    private String shortDesc;
    
    private String dtlDescr;
    
    public enum Category {
		Painting, Sculptor, Ornament
	}

    private Category category;
    
    private String selectedCategory;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.username")
    private String sellerEmail;

    @Override
	public int hashCode() {
		return Objects.hash(productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return productId == other.productId;
	}

	private Double price;

    private Date bidEndDate;
    

   

}
