package ss.week4;
import ss.utils.TextIO;
import ss.week4.tictactoe.Game;
import ss.week4.tictactoe.HumanPlayer;
import ss.week4.tictactoe.Mark;
import ss.week4.tictactoe.Player;

public class TikTacToe {
	public static void main(String[] args) {
		Mark starting = Mark.OO;
		String[] player = new String[2];
		System.out.print("Please enter the first palyer name: ");
		player[0] = TextIO.getlnString();
		System.out.print("Please enter the second palyer name: ");
		player[1] = TextIO.getlnString();
		
		Player one = new HumanPlayer(player[0], starting);
		Player two = new HumanPlayer(player[1], starting.other());
		
		Game game = new Game(one, two);
		game.start();
	}
}
