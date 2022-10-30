package com.casestudy.eauction.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Seller implements Serializable {

	private String firstName;
	private String lastName;
	private String address;
	private Long phoneNumber;
	@Id
	private String emailId;
	private String city;
	private String state;
	private String pin;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="seller",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> products;
    
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
