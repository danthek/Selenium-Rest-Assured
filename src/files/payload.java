package files;

public class payload {
	public static String AddPlace() { // if declared static. then in the other file we dont need to create a method for it
		return "{\r\n"
				+ "  \"location\": {\r\n" 
				+ "    \"lat\": -38.383494,\r\n" 
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" 
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Deutsch Schule fur QA Testers\",\r\n"
				+ "  \"phone_number\": \"(+52) 312 893 3937\",\r\n"
				+ "  \"address\": \"29, Hamburg, Germany 09\",\r\n" 
				+ "  \"types\": [\r\n"
				+ "    \"Schule\",\r\n" 
				+ "    \"lernen\"\r\n" 
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n" 
				+ "  \"language\": \"Deutsch-IN\"\r\n" 
				+ "}";
	}

	public static String complexJson() {
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String bookAdd(String isbn, String aisle) { 
		// different than the previous methods, this time we can store and return the whole JSON body inside a single variable
		String jsonVariable= "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+ isbn +"\",\r\n"
				+ "\"aisle\":\""+ aisle +"\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}\r\n"
				+ "";
	return jsonVariable;
	}
}
