package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete {
	
	@Test
	public void test() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RestAssured.given().when().delete().then().log().all().statusCode(204);
		
		
	}

}
