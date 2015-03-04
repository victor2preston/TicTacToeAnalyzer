package TicTacToe;

public class LeftEdgeCell extends EdgeCell{
	
	public LeftEdgeCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}
	

	
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){
		if(addLikeEntry(TicTacToeDirection.EastWest,this)){
			winnerSoFar = getWinnerType();
		}
		return super.getResults(winnerSoFar);
		
	}

	public TicTacToeCell fGetResults(TicTacToeResults winnerSoFar){
		if(addLikeEntry(TicTacToeDirection.EastWest,this)){
			winnerSoFar = getWinnerType();
		}
		return super.fGetResults(winnerSoFar);
		
	}
	public TicTacToeCell fnGetEntries(){
		addLikeEntry(TicTacToeDirection.EastWest,this);
		return super.fnGetEntries();
		
	}
}
