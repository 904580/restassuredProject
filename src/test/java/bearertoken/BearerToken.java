package bearertoken;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class BearerToken {

	@Test
	public void bearertoken() {
		
		RequestSpecification reqSpec = RestAssured.given();
		
		//https://gorest.co.in/public/v2/users
		
		reqSpec.baseUri("https://gorest.co.in");
		reqSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name","Atul");
		payload.put("gender","Male");
		payload.put("email","Atul@gmail.com");
		payload.put("status","Active");
		
		String AuthToken ="Bearer e9d39dbf2c2affb9197111c1f8b77b8274ef000202364eb94a10aa193e827c83";
		
		reqSpec.header("Authorization","AuthToken").
		contentType(ContentType.JSON).body(payload.toJSONString());
		
		//PERFORM POST REQ
		Response response=reqSpec.post();
		
		Assert.assertEquals(response.statusCode(),201);
		
		//print status line
		
		System.out.println("response stataus line:" + response.statusLine());
		System.out.println("response body:" + response.body().asString());
		
			
	}

}
