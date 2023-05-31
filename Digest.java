package digestauth;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Digest {
	
	@Test
	public void DigestAuth() {
	
		RequestSpecification reqspec =RestAssured.given();
		
		reqspec.baseUri("https://httpbin.org/");
		reqspec.basePath("digest-auth/undefined/anoop/anoop");
		
		Response response =reqspec.auth().digest("anoop","anoop").get();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		System.out.println("Digest response Line: " + response.statusLine());
		System.out.println("Digest response Body: " + response.body().asString());
		
	}

}
