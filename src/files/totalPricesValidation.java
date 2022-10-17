package files;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class totalPricesValidation<coursesCountx> {

	JsonPath js = new JsonPath(payload.complexJson()); // this is a mocked response
	int coursesCountx2 = js.getInt("courses.size()");
	int purchaseAmountx2 = js.getInt("dashboard.purchaseAmount");

	@Test
	public void sumOfCourses(int coursesCount, int purchaseAmount, int totalAmount) {

		for (int i = 0; i < coursesCountx2; i++) {
			int prices = js.getInt("courses[" + i + "].price");
			int allCopies = js.getInt("courses[" + i + "].copies");
			int subTotal = prices * allCopies;
			totalAmount += subTotal;
		}

		// Verify if Sum of all Course prices*copies matches with Purchase Amount
		System.out.println("The total amount is: " + totalAmount);
		Assert.assertEquals(purchaseAmountx2, totalAmount);

	}

	@Test
	public void titleAndPrice(int coursesCount) {
		JsonPath js = new JsonPath(payload.complexJson());
		coursesCount = js.getInt("courses.size()");
		for (int i = 0; i < coursesCount; i++) {
			String titleCourses = js.get("courses[" + i + "].title");
			int prices = js.getInt("courses[" + i + "].price");

			// Print All course titles and their respective Prices
			System.out.println(" Print Title & price of each course: " + titleCourses + " ,Price " + prices);

		}

	}

	// The following code only functions if its not called in another file i.e. :
	// totalPricesValidation theValidations = new totalPricesValidation();
	// Verify if Sum of all Course prices*copies matches with Purchase Amount
	// theValidations.sumOfCourses(purchaseAmount, purchaseAmount, purchaseAmount,
	// js)
	// So it can onnly be used locally or via a .xml test file
	/*
	 * @Test(dataProvider = "getData") public void sumOfCourses(int coursesCountx2,
	 * int purchaseAmountx2, int totalAmountx2, JsonPath js ) { //JsonPath js = new
	 * JsonPath(payload.complexJson());
	 * 
	 * for (int i = 0; i < coursesCountx2; i++) { int prices = js.getInt("courses["
	 * + i + "].price"); int copies = js.getInt("courses[" + i + "].copies"); int
	 * subTotal = prices * copies; totalAmountx2 += subTotal; }
	 * 
	 * // Verify if Sum of all Course prices*copies matches with Purchase Amount
	 * //System.out.println("The total amount issss: " + hola);
	 * System.out.println("The total amount issss: " + totalAmountx2);
	 * Assert.assertEquals(purchaseAmountx2, totalAmountx2); }
	 * 
	 * @DataProvider public Object[][] getData() { JsonPath js = new
	 * JsonPath(payload.complexJson()); int coursesCountx2 =
	 * js.getInt("courses.size()"); int purchaseAmountx2 =
	 * js.getInt("dashboard.purchaseAmount"); int totalAmountx2 = 0; String hola=
	 * "hello"; Object[][] data = new Object[1][4]; // the order must be respected
	 * in the function when catching this parameters data[0][0] = coursesCountx2;
	 * data[0][1] = purchaseAmountx2; data[0][2] = totalAmountx2; data[0][3] = js;
	 * 
	 * return data; }
	 */

}
