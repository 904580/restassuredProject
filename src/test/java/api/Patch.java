package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Patch {
	
	@Test
	public void test04() {
		 
			
			JSONObject jsonData = new JSONObject();
			jsonData.put("name", "saini");
			jsonData.put("job", "tester");
			
			RestAssured.baseURI="https://reqres.in/api/users/398";
			RestAssured.given().header("Content-type","application/json").
			contentType(ContentType.JSON).body
			(jsonData.toJSONString()).when().patch().then().statusCode(200).log().all();
			
	}

}
