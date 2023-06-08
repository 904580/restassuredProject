package API2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.BookData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddBook {
	
	@Test
	public void addNewBook() {
		
		BookData d = new BookData();
		d.setName("Test");
		d.setIsbn("adfs");
		d.setAisle("12345");
		d.setAuthor("Rahul");
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().header("Content-Type","application/json").body(d).
		when().post("Library/Addbook.php").then().assertThat().statusCode(200);
		
	}
}
