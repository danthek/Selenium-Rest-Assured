package files;

public class randomId {
	// Random id generator

	public static String[] idGenerator() {
		String[] randomId = new String[2];

		String isbn = "";
		String aisle = "";
		String characters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		for (int i = 0; i < 4; i++) {
			isbn += characters.charAt((int) Math.floor(Math.random() * 26));
			aisle += numbers.charAt((int) Math.floor(Math.random() * 10));
		}
		randomId[0] = isbn;
		randomId[1] = aisle;
		return randomId;
	}


}
