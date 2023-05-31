package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Post {      //signup api
	
	@Test(priority=0)
	public void test03() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("first-name", "gorge");
		jsonData.put("last-name", "bob");
		jsonData.put("email", "gorgebob@gmail.com");
		jsonData.put("designation", "Dentist");
		jsonData.put("hospital-name","EyeCare Hospital");
		jsonData.put("hospital-address","Noida");
		jsonData.put("password", "Noida@1234");
		
		
		RestAssured.baseURI="https://api.manentia.ai/api/signup/";
		RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).body
		(jsonData.toJSONString()).when().post().then().statusCode(201).log().all();
		
	}




@Test(priority=1)
public void test04() {
	
	JSONObject jsonData = new JSONObject();
	jsonData.put("first-name", "gorge");
	jsonData.put("last-name", "bob");
	jsonData.put("email", "gorgebob@gmail.com");
	jsonData.put("designation", "Dentist");
	jsonData.put("hospital-name","EyeCare Hospital");
	jsonData.put("hospital-address","Noida");
	jsonData.put("password", "Noida@1234");
	
	
	RestAssured.baseURI="https://api.manentia.ai/api/signup/";
	RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).body
	(jsonData.toJSONString()).when().post().then().statusCode(406).log().all();
	
}



@Test(priority=2)
public void test05() {
	
	JSONObject jsonData = new JSONObject();
	jsonData.put("first-name", "gorge");
	jsonData.put("last-name", "bob");
	jsonData.put("email", "gorgebob@gmail.com");
	jsonData.put("designation", "Dentist");
	jsonData.put("hospital-name","EyeCare Hospital");
	jsonData.put("hospital-address","Noida");
	jsonData.put("password", "Noida@1234");
	
	
	RestAssured.baseURI="https://api.manentia.ai/api/signup/";
	RestAssured.given().header("Content-type","application/json").contentType(ContentType.JSON).body
	(jsonData.toJSONString()).when().get().then().statusCode(400).log().all();
	
}

}
