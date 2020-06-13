package com.example.demo;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//You might want to annotate ProductCartRepo interface
public interface ProductCartRepo extends JpaRepository<ProductCartModel, Long>{
    
    //user code goes here
}
