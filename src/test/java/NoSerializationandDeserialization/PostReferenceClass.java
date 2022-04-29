package NoSerializationandDeserialization;

import java.util.HashMap;

import javax.swing.text.AbstractDocument.Content;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class PostReferenceClass {
	HashMap<String, String> map;

	@BeforeClass
	public void postSetup() {
		map = new HashMap<String, String>();
		map.put("id", "5");
		map.put("title", "hello");
		map.put("author", "Philips");
		map.put("id", "6");
		map.put("title", "glow");
		map.put("author", "Hitler");

		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/posts";

	}

	@Test
	public void createPost() {
		given().contentType(ContentType.JSON).body(map).when().post().then().statusCode(201).log().all();
	       
	}

}
