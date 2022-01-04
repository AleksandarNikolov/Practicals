package ss.week5.tictactoe;

public class ComputerPlayer extends Player {
	
	private Strategy strategy;
	
	public ComputerPlayer(Mark mark) {
		super("Naive Strategy- " + mark.toString(), mark);
		this.strategy = new NaiveStrategy();
	}
	
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + "-" + mark.toString(), mark);
		this.strategy = strategy;
	}
	

	@Override
	public int determineMove(Board board) {
		return this.strategy.determineMove(board, this.getMark());
	}
	
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	

}
