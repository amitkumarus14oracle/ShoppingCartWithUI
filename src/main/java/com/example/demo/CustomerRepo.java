package com.example.demo;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//You might want to annotate CustomerRepo interface
public interface CustomerRepo extends JpaRepository<CustomerModel, Long>{
	
	// user code goes here
}
