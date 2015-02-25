package TicTacToe;

public class RightCornerCell extends CornerCell {
	
	RightCornerCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){

		//This first part has been done already in LeftCornerCell
//		if(addLikeEntry(TicTacToeDirection.EastWest,this)){
//			winnerSoFar = getWinnerType();
//		}
		if(addLikeEntry(TicTacToeDirection.NorthSouth,this)){
			winnerSoFar = getWinnerType();
		}
		if(addLikeEntry(TicTacToeDirection.DiagonalMinus,this)){
			winnerSoFar = getWinnerType();
		}
		return super.getResults(winnerSoFar);

	}

	

}
