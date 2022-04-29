import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;



public class Test_004_GetReqRes {
	
	

	@Test
	public void getReqRes()
	{
		
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
         .header("Content-Type","application/json; charset=utf-8");
		
		
	}
	

}
