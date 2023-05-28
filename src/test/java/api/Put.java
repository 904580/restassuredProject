package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Put {
	
	@Test
	public void test03() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Anoop saini");
		jsonData.put("job", "QA tester");
		
		RestAssured.baseURI="https://reqres.in/api/users/398";
		RestAssured.given().header("Content-type","application/json").
		contentType(ContentType.JSON).body
		(jsonData.toJSONString()).when().put().then().statusCode(200).log().all();
		
		
	}

}
