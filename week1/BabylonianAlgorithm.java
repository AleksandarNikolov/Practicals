package ss.week1;

import ss.utils.TextIO;

public class BabylonianAlgorithm {

	public static void main(String[] args) {
		System.out.print("Input a positive double: ");
		double n = TextIO.getDouble();
		double guess = n / 2;
		double oldguess = guess;
		double threshold = 100;
		double r;
		
		while (threshold >= 1) {
			
			r = n / guess;
			
			guess = (guess + r) / 2;
			
			if (guess > oldguess) {
				threshold = ((guess - oldguess) / guess) * 100;
			} else if (guess < oldguess) {
				threshold = ((oldguess - guess) / oldguess) * 100;
			}
			
			System.out.print("guess: ");
			System.out.printf("%.2f", guess);
			System.out.println("");
			
			oldguess = guess;
			
		}
		System.out.print("final guess: ");
		System.out.printf("%.2f", guess);
	}
}
