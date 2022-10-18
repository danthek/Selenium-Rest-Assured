import java.io.FileInputStream;

import org.testng.Assert;

import files.payload;
import files.totalPricesValidation;
import io.restassured.path.json.JsonPath;

public class mockedJson {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(payload.complexJson()); // this is a mocked response
		String copiesTitle = "RPA";
		int totalAmount = 0;
		// Print No of courses returned by API
		int coursesCount = js.getInt("courses.size()");
		System.out.println(" No. of courses returned by API: " + coursesCount);

		// Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(" Print Purchase Amount: " + purchaseAmount);

		// Print Title of the first course
		String titleCourse1 = js.get("courses[0].title");
		System.out.println(" Print Title of the first course: " + titleCourse1);

		totalPricesValidation<?> theValidations = new totalPricesValidation<Object>();
		// Verify if Sum of all Course prices*copies matches with Purchase Amount
		theValidations.sumOfCourses(coursesCount, purchaseAmount, totalAmount);
		// Print Title and price of each course
		theValidations.titleAndPrice(coursesCount);

		// Print no of copies sold by RPA Course
		for (int i = 0; i < coursesCount; i++) {
			String titleCourses = js.get("courses[" + i + "].title");
			int copies = js.getInt("courses[" + i + "].copies");
			theCopies(copiesTitle, titleCourses, copies, i);
		}
	}

	// Static Method to check Copies
	public static void theCopies(String copiesTitle, String titleCourses, int copies, int i) {
		String copiesMsg = "";
		if (titleCourses.equalsIgnoreCase(copiesTitle)) { // for some reason we cannot use here "=="
			copiesMsg = ("The number of  copies of " + copiesTitle + " is: " + copies);
			System.out.println(copiesMsg);
		}
		return;

	}

}
