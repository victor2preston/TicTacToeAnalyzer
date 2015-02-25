package TicTacToe;

public interface LikeFinder {
	
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar);

	public int getCount(TicTacToeDirection direction);
	
	public void incrementCount(TicTacToeDirection direction);

}
