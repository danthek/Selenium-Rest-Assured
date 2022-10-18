package files;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {

	public static <string> JsonPath rawToJson(String response) {
		// extracting data from an external file
		generalData myData = new generalData();
		String updateAddress = myData.newAddress;
		String field = myData.jsonField;

		JsonPath getJson = new JsonPath(response);
		String responseGet = getJson.get(field); // we extract and store the whole response inside a new variable
		Assert.assertEquals(responseGet, updateAddress);
		// System.out.println("This is the new address: " + responseGet);
		return getJson;

	}

	public static <string> JsonPath rawToJsonSimple(String response, String item) {
//Simple resuable method that recieves the response and a parameter
		JsonPath getJson = new JsonPath(response);
		String responseGet = getJson.get(item); // we extract and store the whole response inside a new variable
		String addSuccess = getJson.get("Msg"); // we extract and store the whole response inside a new variable
		Assert.assertEquals(addSuccess, "successfully added");
		System.out.println("This is the " + item + " value : " + responseGet);
		return getJson;

	}

}
