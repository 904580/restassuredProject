package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Patch {
	
	@Test
public void test() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "neeraj");
		jsonData.put("job", "YT");
		
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RestAssured.given().header("Content-type","application/json")
		.contentType(ContentType.JSON).body
		(jsonData.toJSONString()).when().patch()
		.then().statusCode(200).log().all();
		
	}
}