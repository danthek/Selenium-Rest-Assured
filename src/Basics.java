import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.Assert;

import files.ReusableMethod;
import files.generalData;
import files.payload;

public class Basics {

	public static void main(String[] args) {
		// payload Payload = new payload(); // object creation of the payload
		// method,-> this isn't needed if the ÄddPlace method is declared as static
		// Validate if Add Place API is working as expected
		// Add Place-> Update place with new address -> Get place to validate if new
		// Address is present in response
		// REST assured : give, When, Then
		// Given: All input details we need to submit for an API-params, header, body
		// When: Submit the API-resources, https method
		// Then: Validate the response

		//////////////////////////////////// P O S T////////////////////////////////////
		System.out.println("//////////////////////////////////// P O S T////////////////////////////////////");
		// first indicate the baseURI
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		// Given we provide the query and how we are sending the data (header), body raw
		String myResponse = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(payload.AddPlace()) // we call the json inside the
																						// payload.AddPlace() Method
				// when we post in certain resources path
				.when().post("maps/api/place/add/json")
				// then we validate the status code
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		System.out.println("This is the response: " + myResponse);
		JsonPath js = new JsonPath(myResponse); // for parsing JSON: takes a string as an input and converts it to JSON
		String placeId = js.get("place_id"); // we only read the "place_id" item inside the JSON
		System.out.println("This is the placeId: " + placeId);

		//////////////////////////////////// PUT ////////////////////////////////////
		System.out.println("//////////////////////////////////// P U T ////////////////////////////////////");
		generalData myData = new generalData();
		String updateAddress = myData.newAddress;
		String updateResponse= given().log().all().queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body("{\r\n"
					+ "\"place_id\": \""+ placeId +"\",\r\n"
					+ "  \"address\": \""+ updateAddress +"\",\r\n"
					+ "  \"key\": \"qaclick123\"\r\n"
					+ "}\r\n"
					+ "")
		 .when().put("maps/api/place/update/json") // we use the PUT method
		 .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().response().asString();
		JsonPath putJson = new JsonPath(updateResponse);
		String responseMsg = putJson.get("msg"); // we store the whole response inside a new variable
		System.out.println("This is the response msg: " + responseMsg);
		String updateMsg = myData.updateSuccesfull;
		Assert.assertEquals( responseMsg, updateMsg); //We validate if the json response after the "put" matches the correct string msg
	
		//////////////////////////////////// GET  ////////////////////////////////////
		System.out.println("//////////////////////////////////// G E T ////////////////////////////////////");
		String getResponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId) // no header needed but instead a second query parameter
		.when().get("maps/api/place/get/json") // we use the GET method
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		//JsonPath getJson = new JsonPath(getResponse); //"JsonPath native class expects always a string as a value
		
		 ReusableMethod.rawToJson(getResponse); // we made this to make it more readable and capsulated it all inside an external class
		
	}

}

