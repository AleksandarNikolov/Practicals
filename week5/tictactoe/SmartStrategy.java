package ss.week5.tictactoe;

import java.util.ArrayList;

public class SmartStrategy implements Strategy {

	@Override
	public String getName() {
		return "Smart Strategy";
	}

	@Override
	public int determineMove(Board board, Mark mark) {
		int middleField = (Board.DIM * Board.DIM) / 2;
		
		ArrayList<Integer> empty = new ArrayList<Integer>();
		for (int i = 0; i < Board.DIM * Board.DIM; i++) {
			if (board.isEmptyField(i)) {
				empty.add(i);
			}
		}
		
		if (board.getField(middleField).equals(Mark.EMPTY)) {
			return middleField;
		} else {
			for (Integer emptyField: empty) {
				Board testWinner = board.deepCopy();
				
				testWinner.setField(emptyField, mark);
				if (testWinner.isWinner(mark)) {
					return emptyField;
				}
				
				testWinner.setField(emptyField, mark.other());
				if (testWinner.isWinner(mark.other())) {
					return emptyField;
				}
			}
			
			return (new NaiveStrategy()).determineMove(board, mark);
			
		}
	}

}
