package TicTacToe;

abstract public class EdgeCell extends TicTacToeCell {

	private int count= 0;

	public EdgeCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}

	//Override	
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){
		return super.getResults(winnerSoFar);
	}
	
	//Override
	public int getCount(TicTacToeDirection direction) {
			return count;
		}
	//Override
	public void incrementCount(TicTacToeDirection direction){
		count++;
	}
}
