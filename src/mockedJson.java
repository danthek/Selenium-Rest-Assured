import java.io.FileInputStream;

import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class mockedJson {

	public static void main(String[] args) {

		String copiesTitle = "RPA";
		JsonPath js = new JsonPath(payload.complexJson()); // this is a mocked response

		// Print No of courses returned by API
		int coursesCount = js.getInt("courses.size()");
		System.out.println(" No. of courses returned by API: " + coursesCount);

		// Print Purchase Amount
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(" Print Purchase Amount: " + purchaseAmount);

		// Print Title of the first course
		String titleCourse1 = js.get("courses[0].title");
		System.out.println(" Print Title of the first course: " + titleCourse1);

		// Print All course titles and their respective Prices
		for (int i = 0; i < coursesCount; i++) {
			String titleCourses = js.get("courses[" + i + "].title");

			int copies = js.getInt("courses[" + i + "].copies");
		
			
			// Print no of copies sold by RPA Course
			theCopies(copiesTitle, titleCourses, copies, i);
		}

		//Verify if Sum of all Course prices*copies matches with Purchase Amount
				totalPricesValidation.sumOfCourses();
				totalPricesValidation.titleAndPrice();

	}

	// Static Method to check Copies
	public static void theCopies(String copiesTitle, String titleCourses, int copies, int i) {
		String copiesMsg = "";
		if (titleCourses.equalsIgnoreCase(copiesTitle)) { // for some reason we cannot use here "=="
			copiesMsg = ("The number of  copies of " + copiesTitle +" is: " + copies);
			System.out.println(copiesMsg);
		}
		return;

	}

}
