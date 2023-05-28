package basicauth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthntication {
	
	@Test
	public void basicauthntication() {
		
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("http://postman.echo.com");
		reqspec.basePath("/basic-auth");
		
		
		//PERFORM GET REQUEST
		Response responses =reqspec.auth().basic("postman", "password").get();
		
		//print status line
		System.out.println("Response Status:" + responses.getStatusLine());
		System.out.println("Response Body:" + responses.body().asString());	
		
	}

}
