import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Test_002_GetWeatherDetails {

	@Test(priority = 1)
	public void getWeatherReportCity() {

		// anything after q stands out for query parameter

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

	// Use json path finder to find the detailed object you are looking for in Json
	// format
	// Also, We use rest not Soap since soap response is in .xml file which is hard
	// to decode
	// Rest gives us an option of getting the response in Json and .xml
	// Json stands for javascript object notation --- which gives the data in key
	// and value format
	@Test()
	public void getWeatherPathByCity() {
		String resp = given().param("q", "London").param("appid", "0607d2db43c40c75e5f6533401ba1ed5")

				.when().get("https://api.openweathermap.org/data/2.5/weather")

				.then().contentType(ContentType.JSON)

				.extract().path("weather[0].description");

		System.out.println("Weather description is :" + resp);
		// output:Weather description is :clear sky

	}
    @Test 
	public void getWeatherLangAndLong() {

		Response resp = given().param("q", "London").param("appid", "0607d2db43c40c75e5f6533401ba1ed5").when()
				.get("https://api.openweathermap.org/data/2.5/weather");

		String longitude = String.valueOf(resp.then().contentType(ContentType.JSON).extract().path("coord.lon"));

		String latitude = String.valueOf(resp.then().contentType(ContentType.JSON).extract().path("coord.lat"));

		System.out.println("Longitude value is ::" +longitude);
		System.out.println("latitude value is ::" +latitude);

		Assert.assertEquals(longitude, "-0.1257");
		Assert.assertEquals(latitude, "51.5085");

	}

}
