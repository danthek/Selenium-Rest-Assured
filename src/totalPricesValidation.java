import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class totalPricesValidation {


	@Test
	public static void sumOfCourses() {
		JsonPath js = new JsonPath(payload.complexJson());
		int coursesCount = js.getInt("courses.size()");
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		int totalAmount = 0;
		for (int i = 0; i < coursesCount; i++) {
			int prices = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");
			int subTotal = prices * copies;
			totalAmount += subTotal;
		}

		// Verify if Sum of all Course prices*copies matches with Purchase Amount
		System.out.println("The total amount is: " + totalAmount);
		Assert.assertEquals(purchaseAmount, totalAmount);

	}

	@Test
	public static void titleAndPrice() {
		JsonPath js = new JsonPath(payload.complexJson());
		int coursesCount = js.getInt("courses.size()");
		for (int i = 0; i < coursesCount; i++) {
			String titleCourses = js.get("courses[" + i + "].title");
			int prices = js.getInt("courses[" + i + "].price");

			// Print All course titles and their respective Prices
			System.out.println(" Print Title & price of each course: " + titleCourses + " ,Price " + prices);

		}

	}
}


