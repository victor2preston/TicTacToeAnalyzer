package TicTacToe;

import java.util.Collection;

abstract public class EdgeCell extends TicTacToeCell {

	private int count= 0;

	public EdgeCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}

	//Override	
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){
		return super.getResults(winnerSoFar);
	}
	public TicTacToeCell fGetResults(TicTacToeResults winnerSoFar){
		return super.fGetResults(winnerSoFar);
	}
	public TicTacToeCell fnGetResults(TicTacToeCell rootCell){
		return super.fnGetResults(rootCell);
	}
	
	//Override
	public TicTacToeCell fnGetEntries(){
		return super.fnGetEntries();
	}
	
	//Override
	public int getCount(TicTacToeDirection direction) {
			return count;
		}
	//Override
	public void incrementCount(TicTacToeDirection direction){
		count++;
	}
	//Override
	public void resetCount(){
		count = 0;
	}
}
