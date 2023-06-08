package API2;

import io.restassured.path.json.JsonPath;

public class MockTest {
	
	
	
	public void MockAPI() {
		
		
		
	}
	
	JsonPath js = new JsonPath(AddPlace.placePayload);
	
	//number of courses
	
	int totalCourses=js.getInt("courses.size()");
	System.out.println("totalCourses");
	
	
	//first courses title
	
	String titleFirstCourses=js.getString("courses[0].title");
	System.out.println("titleFirstCourses");
	
	//title and price of all courses
	
	for(i=0;i<totalCourses;i++) {
		
		String str = js.getString("courses["+i+"].title");
		System.out.println("title");
		
		if(title.equals("RPA")) {
			int copies = js.getInt("courses["+i+"].copies");
			System.out.println(copies);
		}
		
		int price = js.getInt("courses["+i+"].price");
		System.out.println(price);
	}
	
// purchase amount and total courses price
	
	int sum=0;
	for(int j=0; j<totalCourses ;j++) {
		
		int copies = js.getInt("courses["+j+"].copies");
		int prices= js.getInt("courses["+j+"].price");
		
		int TotalPrice = copies*prices;
		
		sum=sum+TotalPrice;
	}
	System.out.println(sum);
	
	
	int purchaseAmount =js.getInt("dashboard.purchaseAmount");
	System.out.println(purchaseAmount);
	
	assertEquals(sum,purchaseAmount);
}

