import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicTestValidations {

	@Test(enabled = false)
	public void getTestReponse() {
		given().when().get("https://jsonplaceholder.typicode.com/posts/2").then().statusCode(200).log().all();

	}

	@Test(priority=2)
	public void getTestSingleContent() {
		given().when().get("https://jsonplaceholder.typicode.com/posts/2").then()
				.header("Content-Type", "application/json; charset=utf-8")
				.statusCode(200).log().all()
				.body("title", equalTo("qui est esse"));
		

	}

}
