package ss.week1;
import ss.utils.TextIO;

public class GrossAndDozens {
	public static void main(String[] args) {
		System.out.print("Enter amount of eggs: ");
		int eggs = TextIO.getlnInt();
		int gross = eggs / 144;
		int dozen = gross / 12;
		eggs = gross % 12;
		System.out.print("Your number of eggs is " + gross + " gross, ");
		System.out.print(dozen + " dozen, and " + eggs);
	}
}
