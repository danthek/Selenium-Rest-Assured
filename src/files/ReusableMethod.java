package files;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {

	public static <string> JsonPath rawToJson(String response) {
		generalData myData = new generalData();
		String updateAddress = myData.newAddress;
		String field = myData.jsonField;
		JsonPath getJson = new JsonPath(response);
		String responseGet = getJson.get(field); // we extract and store the whole response inside a new variable
		Assert.assertEquals(responseGet, updateAddress);
		System.out.println("This is the new address: " + responseGet);
		return getJson;

	}

}
