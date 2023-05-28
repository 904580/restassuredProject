package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get {
	
	@Test
	public void test02() {
		
		//given,when,then
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200).log().all();
		
	}
	
}
