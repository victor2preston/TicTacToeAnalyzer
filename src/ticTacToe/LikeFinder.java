package ticTacToe;

public interface LikeFinder {
	
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar);
	
	public TicTacToeCell fnGetEntries();

	public int getCount(TicTacToeDirection direction);
	
	public void incrementCount(TicTacToeDirection direction);
	
	public void resetCount();

}
