package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get { //Logout API
	
	@Test
	public void test02() {
		
		//given,when,then
		RestAssured.baseURI="https://api.manentia.ai/api/signout/";
		RestAssured.given().when().get().then().statusCode(200).log().all();
		
	}
	
}
