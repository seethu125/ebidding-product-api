package com.casestudy.eauction.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity
@IdClass(BuyerKey.class)
public class Buyer implements Serializable{

	private String firstName;
	private String lastName;
	private String address;
	private Long phoneNumber;
    @Id
	private String buyerEmailId;
    @Id
	private int productId;
	private String city;
	private String state;
	private String pin;
	private Double bidAmount;
}
