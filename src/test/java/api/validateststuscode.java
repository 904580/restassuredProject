package api;

import org.testng.annotations.Test;

import  io.restassured.RestAssured;

public class validateststuscode {
	
	@Test
	public void tewst06() {
		RestAssured.given();
		RestAssured.when();
		RestAssured.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.statusLine("Http/1.1 200 ok");
		
		
	}

}
