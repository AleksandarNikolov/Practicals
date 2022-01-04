package ss.utils;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
	public static void main(String[] args) {
		try {
			String[] text;
			File myObj = new File("C:\\softwaresystems\\java\\ss\\week1\\eclipse-workspace\\SoftwareSystems\\src\\ss\\embed.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.length() < 350) {
					System.out.print(data);
				} else if (data.contains("role=\"img\" aria-label=")) {
					text = data.split("role=\"img\" aria-label=");
					if (!text[1].contains("http")) {
						System.out.println(text[1]);
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
