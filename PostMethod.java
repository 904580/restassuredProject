package API2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payload.AddPlace;



public class PostMethod {
	
	@Test
	public void PostApi() {
		
		RestAssured.baseURI=" https://api.manentia.ai/api/signup/";
		given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json").body(AddPlace.placePayload())
				
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).log().all();
		//.body("status", equalTo("OK"));
		
	}}
