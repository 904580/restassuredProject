package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Put {
	
	@Test
public void test() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "gorge");
		jsonData.put("job", "teacher");
		
		
		RestAssured.baseURI="https://reqres.in/api/users/2";
		RestAssured.given().header("Content-type","application/json")
		.contentType(ContentType.JSON).body
		(jsonData.toJSONString()).when().put()
		.then().statusCode(200).log().all();
		
	}


}
