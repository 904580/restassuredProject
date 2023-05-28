package API2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payload.AddPlace;



public class PostMethod {
	
	@Test
	public void PostApi() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json").body(AddPlace.placePayload())
				
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).log().all().header("Server", "Apache/2.4.41 (Ubuntu)");
		//.body("status", equalTo("OK"));
		
	}}
