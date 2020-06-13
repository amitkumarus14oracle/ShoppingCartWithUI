package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//you might want to annnotate CustomerModel class
@Component
public class CustomerModel implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	//you might want to annotate customerId attribute
	private long customerId;
	private String name;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String contact;

	// setters & getters goes here
}
