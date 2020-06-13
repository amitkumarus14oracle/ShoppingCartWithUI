package com.example.demo;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;

	  @GetMapping("/api/products")
	    public List<ProductModel> getAllDetails() {
	        return productRepo.findAll();
	    }
	  
	  @PostMapping("/api/products")
	     public Response saveAllDetails(@RequestBody ProductModel  details){
		  productRepo.save(details);
		  return Response.created(URI.create("/" + details.getProductId())).build();
	  }
}