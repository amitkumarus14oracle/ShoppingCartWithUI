package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//you might want to annnotate ProductCartModel class
public class ProductCartModel implements Serializable {
	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//you might want to annotate cartId attribute
	private long cartId;
	 
	private String photo;
	private String name;
	
	private String model;
	private double price;
	
	private int quantity;
	// setters & getters goes here
}
