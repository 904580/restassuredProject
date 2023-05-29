package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {

	
	@Test(priority=0)
	public void basicauthntication() {
		
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://api.manentia.ai/");
		reqspec.basePath("api/signin/");
		
		
		//PERFORM GET REQUEST
		Response responses =reqspec.auth().basic("Email", "password").get();
		
		//print status line
		System.out.println("Response Status:" + responses.getStatusLine());
		System.out.println("Response Body:" + responses.body().asString());	
		
		int Actual =201;
		int  Expected=401;
	
		
		Assert.assertEquals(Actual,Expected);
		
	}
	
	
	@Test(priority=1)
	public void Unauth() {
		
		RestAssured.baseURI="https://api.manentia.ai/api/dashboard/";
		RestAssured.given().when().get().then().statusCode(401).log().all();
		

	}
	
	@Test(priority=2)
	public void hit() {
		
		RestAssured.baseURI="https://api.manentia.ai/api/dashboard/";
		RestAssured.given().when().post().then().statusCode(401).log().all();
		

	}
}


