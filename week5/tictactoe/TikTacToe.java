package ss.week5.tictactoe;
import ss.utils.TextIO;

public class TikTacToe {
	public static void main(String[] args) {
		Mark starting = Mark.OO;
		Player one;
		Player two;
		String[] player = new String[2];

		
		System.out.print("Please enter the first palyer name: ");
		player[0] = TextIO.getlnString();
		System.out.print("Please enter the second palyer name: ");
		player[1] = TextIO.getlnString();
		
		
		
		if (player[0].equals("-N")) {
			one = new ComputerPlayer(starting);
		} else if (player[0].equals("-S")) {
			one = new ComputerPlayer(starting, new SmartStrategy());
		} else {
			one = new HumanPlayer(player[0], starting);
		}
		
		if (player[1].equals("-N")) {
			two = new ComputerPlayer(starting.other());
		} else if (player[1].equals("-S")) {
			two = new ComputerPlayer(starting.other(), new SmartStrategy());
		} else {
			two = new HumanPlayer(player[1], starting.other());
		}
		
		Game game = new Game(one, two);
		game.start();
	}
}
