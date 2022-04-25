import org.apache.poi.util.SystemOutLogger;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Test_002_GetWeatherDetails {

	@Test(priority = 1)
	public void getWeatherReportCity() {

		Response response = when()
				.get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=0607d2db43c40c75e5f6533401ba1ed5");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, enabled = false)
	public void getWeatherdetailsWithParam() {
		Response response = given().param("appid", "0607d2db43c40c75e5f6533401ba1ed5").param("q", "London").

				when().get("https://api.openweathermap.org/data/2.5/weather");
		System.out.println(response.getStatusCode());

	}

	@Test(priority = 3)
	public void getWeatherDetailsCheckWithInAssert() {
		given().param("q", "London").param("appid", "0607d2db43c40c75e5f6533401ba1ed5").

				when().get("https://api.openweathermap.org/data/2.5/weather").

				then().assertThat().statusCode(200);

	}

	@Test(priority = 4)

	public void getWeatherDetailsByCityId() {

		Response resp = given().param("id", "4002796").param("appid", "0607d2db43c40c75e5f6533401ba1ed5").when()
				.get("api.openweathermap.org/data/2.5/forecast");

		System.out.println(resp.getStatusCode());
		System.out.println(resp.toString());
	}

}
