package TicTacToe;

public class UpperEdgeCell extends EdgeCell {

	UpperEdgeCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){
		if(addLikeEntry(TicTacToeDirection.NorthSouth,this)){
			winnerSoFar = getWinnerType();
		}
		return winnerSoFar;
		
	}

	public TicTacToeCell fGetResults(TicTacToeResults winnerSoFar){
		if(addLikeEntry(TicTacToeDirection.NorthSouth,this)){
			winnerSoFar = getWinnerType();
		}
		return this;
		
	}

	public TicTacToeCell fnGetEntries(){
		addLikeEntry(TicTacToeDirection.NorthSouth,this);
		return super.fnGetEntries();
		
	}
}
