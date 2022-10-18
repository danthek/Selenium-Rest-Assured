package files;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class dynamicJson {
	String res = "";
	String id = "";

	// POST
	@Test(dataProvider = "booksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		res = given().log().all().header("Content-Type", "application/json").body(payload.bookAdd(isbn, aisle)).when()
				.post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
		JsonPath newJs = ReusableMethod.rawToJsonSimple(res, "ID");
		id = newJs.get("ID");
		deleteBook(id); // here we call the delete method and send the id for it to delete it

	}
	
	// Tip for readyn Json file url: .body(Files.readAllBytes(Paths.get("C:\\user\documents\thefile.json"))) 

	// Delete

	public static void deleteBook(String id) {

		String deleteRes = given().log().all().header("Content-Type", "application/json")
				.body(("{\r\n" + "\"ID\" : \"" + id + "\"\r\n" + "} \r\n" + "")).when().post("Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath deletemsg = new JsonPath(deleteRes);
		String successDelete = deletemsg.get("msg");
		Assert.assertEquals(successDelete, "book is successfully deleted");
		// System.out.println(idGenerator());
	}

	///////////// Data Provider ///////////////
	// with dataprovider we send different groups of data to the same @test so we
	// Don't need many different @test methods

	@DataProvider(name = "booksData")
	public Object[][] getData() {

		String[] ans = new String[0];
		Object[][] data = new Object[3][2];

		for (int i = 0; i < 3; i++) {
			ans = randomId.idGenerator();
			data[i][0] = ans[0];
			data[i][1] = ans[1];
		}

		/*
		 * The above "for" loops help us avoid doing it manually: 
		 * data[0][0] = ans[0];
		 * data[0][1] = ans[1]; 
		 * data[1][0] = ans[0]; 
		 * data[1][1] = ans[1]; 
		 * data[2][0] = ans[0]; 
		 * data[2][1] = ans[1];
		 */

		return data;
	}

	// Another tyoe of dataprovider style:
	/*
	 * @DataProvider(name = "booksData") public Object[][] getData() { 
	 * return new Object[][] {{"",""},{"",""},{"",""}}; }
	 */
}
