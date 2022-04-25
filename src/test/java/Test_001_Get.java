import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_001_Get {

	@Test
	public void getEmployeeDetails() {
		// Step -1 ::->Specific Base Url
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Step -2::->Send Request-->Request Object

		RequestSpecification httpRequest = RestAssured.given();

		// Step -2::->Response -->Respone Object

		Response response = httpRequest.request(Method.GET, "/employees");
		// Get Response on Console
		String JsonResponseOfTheRequest = response.getBody().toString();

		System.out.println("Json Format Response Body" + JsonResponseOfTheRequest);

	}

}
