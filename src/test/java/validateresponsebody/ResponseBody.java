package validateresponsebody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseBody {
	
	@Test
	public void ResponseBodyValidate() {
		
		RequestSpecification reqspec= RestAssured.given();
		
		//specify base URI & base path
		reqspec.baseUri("https://reqres.in/");
		reqspec.basePath("api/users?page=2");
		
		//create perform get request
		Response response=reqspec.get();
		
		//read response body
		ResponseBody resBody = response.getBody();
		
		String responseString = resBody.asString();
		
		System.out.println("Response Body:" + responseString);
		
		//validation presence of george
		
		Assert.assertEquals(responseString.contains("george"),true,"check the george is presence or not");
		
		
	}

	
}




