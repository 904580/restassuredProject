package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Ctscan {
	
	@Test(priority=0)
	public void test02() {
		
		//given,when,then
		RestAssured.baseURI= "https://api.manentia.ai/api/chestCT-reports";
		RestAssured.given().when().get().then().statusCode(401).log().all();
		

}
	
	@Test(priority=1)
	public void test03() {
		
		//given,when,then
		RestAssured.baseURI= "https://api.manentia.ai/api/chestCT-reports";
		RestAssured.given().when().get().then().statusCode(200).log().all();
		

}
}
