package ss.week6;

import java.util.Scanner;

public class Words {
	
	private static final String END_WORD = "end";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a sentence.");
		int i = 1;
		String word;
		while (input.hasNext()) {
			word = input.next();
			if (word.equals(END_WORD)) {
				break;
			}
			System.out.println("Word" + i + " " + word);
			i++;
		}
		
		input.close();
		System.out.println("Line or end");
		System.out.println("End of programme");
		
	}
}
