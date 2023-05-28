package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete {
	
	@Test
	public void test04() {
		
		RestAssured.baseURI="https://reqres.in/api/users/398";
		RestAssured.given().
		when().delete().then().statusCode(204).log().all();
		
		
		
	}

}
