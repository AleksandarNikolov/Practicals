package ss.week5.tictactoe;

import java.util.ArrayList;

public class NaiveStrategy implements Strategy {

	@Override
	public String getName() {
		return "Naive Strategy";
	}

	@Override
	public int determineMove(Board board, Mark mark) {
		ArrayList<Integer> empty = new ArrayList<Integer>();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (board.isEmptyField(i)) {
				empty.add(i);
			}
		}
		
		return empty.get((int) Math.floor(Math.random() * (empty.size() - 1)));
	}


}
