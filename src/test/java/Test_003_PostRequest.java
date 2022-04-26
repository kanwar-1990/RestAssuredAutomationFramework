import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.org.commonPostRequest.PostRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_003_PostRequest {
	PostRequest Pr;

	@Test
	public void getApiCheck() {

		Response resp = given().when().get("http://localhost:3000/posts");

		System.out.println(resp.asString());
	}

	@Test(enabled = false)
	public void getCreatePostData() {

		Response resp = given().body("{id:2,title:dummytitle,author:kanwar}").when().contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");

		System.out.println(resp.toString());

	}

	@Test(enabled=false)
	public void getDataPostRequest() {
		Pr = new PostRequest();

		Response resp = given().when().contentType(ContentType.JSON).body(Pr.createCommonData("3", "Hello", "Dummy12"))
				.body(Pr.createCommonData("4", "Hello123", "Dummy1234"))

				.post("http://localhost:3000/posts");

		System.out.println(resp.asString());

	}
	
	@Test
	public  void checkUpdateRequest()
	{
		
		Response resp=given()
		.contentType(ContentType.JSON)
		.when()
		.body("{\"title\":\"change it to hello\"}")
		.patch("http://localhost:3000/posts/2");
		
		System.out.println(resp.asString());
		//{\"title\":\"change it to hello\"}
		 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
