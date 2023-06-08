package API2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.apache.commons.math3.ml.neuralnet.twod.util.LocationFinder.Location;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payload.AddPlace;
import pojo.PlaceData;

public class AddPlaceTest {
	

	@Test
	public void PostApi() {
		
		PlaceData d=new PlaceData();
		Location location = new Location();
		
		location.setLat(-38.383494);
		location.setLng(33.427362);
		
		d.setLocation(location);
		
		d.setAccuracy(50);
		d.setName("testAutomation");
		d.setPhone_number("3435456654");
		d.setAddress("Noida");
		
		List<String>list = newArrayList<String>();
		list.add("shop park");
		list.add("shoe");
		
		d.setTypes("list");
		
		d.setWebsite("http://google.com");
		d.setLanguage("french-IN");
		
		
		
		given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json").
		body(d)		
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.41 (Ubuntu)")
		.body("status", equalTo("Ok"));
		
		
	 	
		
	}

}
