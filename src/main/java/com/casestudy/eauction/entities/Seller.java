package com.casestudy.eauction.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Seller {

	private String firstName;
	private String lastName;
	private String address;
	private Long phoneNumber;
	@Id
	private String emailId;
	private String city;
	private String state;
	private String pin;


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(emailId, other.emailId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId);
	}
	
	
}
