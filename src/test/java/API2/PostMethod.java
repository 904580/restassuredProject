package API2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.AddPlace;



public class PostMethod {
	
	@Test
	public void PostApi() {
		
		 RestAssured.baseURI="http://rahulshettyacademy.com/";
		 Response re=given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json").
		body(AddPlace.placePayload())
				
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.41 (Ubuntu)").extract().response();
		
		 long responseTime=re.getTime();
		 System.out.println(responseTime);
	int statuscode=	re.getStatusCode();
	assertEquals(200,statuscode);
		
		
	}
	
}
