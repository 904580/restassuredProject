package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Getmethod {
	
	@Test
	void test2() 
	
	
	{
		
	Response res =RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println("response code:" +res.getStatusCode());
	System.out.println("response time:" +res.getTime());
	System.out.println("response body:" +res.getBody());
	System.out.println("response Header:" +res.getHeader("Content-Type"));
	
		
		//validate status code=200
	
	int expectedStatusCode  = 200;
	int ActualStatusCode =res.getStatusCode();
	Assert.assertEquals(expectedStatusCode,ActualStatusCode );
	}

}
