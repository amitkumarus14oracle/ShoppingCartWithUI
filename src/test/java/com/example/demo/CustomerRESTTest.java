package com.example.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRESTTest {

	
public String url="http://localhost:8000/Shopping-cart-app/api/customer/";

	


	@Test
	public void testOrder1() throws Exception {

		
		given().get(url).then().statusCode(200);  
		
		

	}
	
	
		
	
	
	@Test
	public void testOrder2() throws Exception {
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "name");
		requestParams.put("address", "address");
		requestParams.put("city", "city");
		requestParams.put("state", "state");
		requestParams.put("pincode", "pincode");
		requestParams.put("address", "address");
		
		int beforeLength=given().get(url).then().extract().jsonPath().getList("$").size();
		
		given().header("Content-Type", "application/json").body(requestParams.toJSONString()).post(url).then().statusCode(200).log().all();
		
		
		ValidatableResponse  response=given().get(url).then();
		
	assertThat(response.extract().jsonPath().getList("$").size(),is(beforeLength+1));

	}
	
	
	
	
	
	
}
