package com.example.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCartTest {

	
public String url="http://localhost:8000/Shopping-cart-app/api/productcart/";

@Autowired
CustomerRepo customerRepo;

	


	@Test
	public void testOrder1() throws Exception {

		
		given().get(url).then().statusCode(200);  
		
		

	}
	
	
		
	
	
	@Test
	public void testOrder2() throws Exception {
		JSONObject requestParams = new JSONObject();
		
		
		requestParams.put("name", "test1");
		requestParams.put("photo", "https://images.unsplash.com/photo-1503942142281-94af0aded523?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ&s=343652fb4c1f9b09bffc98b10a0058f3");
		requestParams.put("category", "mobile");
		requestParams.put("quantity", 1);
		requestParams.put("model", "test");
		requestParams.put("price", 1000);
		
		
		
		
		int beforeLength=given().get(url).then().extract().jsonPath().getList("$").size();
		
		given().header("Content-Type", "application/json").body(requestParams.toJSONString()).post(url).then().statusCode(200).log().all();
		
		
		ValidatableResponse  response=given().get(url).then();
		
	assertThat(response.extract().jsonPath().getList("$").size(),is(beforeLength+1));
	}
	
	
	
	
	
	
}
