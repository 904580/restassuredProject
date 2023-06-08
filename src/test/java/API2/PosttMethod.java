package API2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.AddPlace;



public class PosttMethod {
	
	static String placeId;
	public static Workbook book;
	
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
	}
	
	@Test(priority=2,description="find the parsing data",dataProvider="userdata")
	public void PostApi(String name, String address) {
		
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json").
		body(AddPlace.placePayload(name,address))
				
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.41 (Ubuntu)")
		.body("status", equalTo("Ok")).extract().response().asString();;
		
		JsonPath js= new JsonPath(response);
		
		 placeId=js.getString("place_id");
		
		System.out.println(placeId);
		
		
	}
	
	@Test(priority=0,description="find the parsing data",invocationCount=1,groups="Smoke",enabled= false)
	public void getGooglePlaceData() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
				String response=given().log().all().queryParam("key","qaclick123").queryParam("placeId", placeId).when()
				.get("maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
				
				JsonPath js1= new JsonPath(response);
				String address=js1.getString("address");
				System.out.println(address);
				
				assertEquals("29, side layout,cohen 09",address);	
	
	}
	@Test(priority=1)
	public void updateAddress() {
		
		String expectedAddress ="Delhi ncr";
		
		String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","Application/Json").
				body("{\r\n"
						+ "\"place_id\":\""+placeId+"\",\r\n"
						+ "\"address\":\"Sector 75 Noida\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}")
						
				.when().put("maps/api/place/update/json")
				.then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.41 (Ubuntu)").
				extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String newAddress =js.getString("address");
		System.out.println(newAddress);
		assertEquals("expectedAddress", newAddress); 
		
	}
	
//	@DataProvider(name="userdata")
//	public Object[][] getData() {
//		
//		return new Object[][] {{"manish","noida"},{"rahul","delhi"},{"boby","gr.noida"}};	
//		
//	}
	
	@DataProvider(name="userdata")
	public Object[][] getData() {
		
		try {
			FileInputStream file= new FileInputStream("F:\\Backend\\RestAssured\\TestData\\UserData.xlsx");
			try {
				 book =WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet = book.getSheetAt(0);
		
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				
			data[i][j]=	sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		return data;
		
	}
	
	}
