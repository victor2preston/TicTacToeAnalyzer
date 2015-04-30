package ticTacToe;

import java.util.List;

public class RightCornerCell extends CornerCell {
	
	RightCornerCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){

		if(addLikeEntry(TicTacToeDirection.NorthSouth,this)){
			winnerSoFar = getWinnerType();
		}
		if(addLikeEntry(TicTacToeDirection.DiagonalMinus,this)){
			winnerSoFar = getWinnerType();
		}
		return super.getResults(winnerSoFar);

	}


	public TicTacToeCell fGetResults(TicTacToeResults winnerSoFar){
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
		return super.fGetResults(winnerSoFar);

	}
	
	public TicTacToeCell fnGetResults(TicTacToeCell rootCell){
		//This first part has been done already in LeftCornerCell
//		if(addLikeEntry(TicTacToeDirection.EastWest,this)){
//			winnerSoFar = getWinnerType();
//		}
		if(addLikeEntry(TicTacToeDirection.NorthSouth,this)){
			rootCell.setValue(TicTacToeValue.B);
		}
		if(addLikeEntry(TicTacToeDirection.DiagonalMinus,this)){
			rootCell.setValue(TicTacToeValue.B);
		}
		return super.fnGetResults(rootCell);

	}

	public TicTacToeCell fnGetEntries(){
//		addLikeEntry(TicTacToeDirection.EastWest,this); // Already done by LeftCornerCell!
		addLikeEntry(TicTacToeDirection.NorthSouth,this);
		addLikeEntry(TicTacToeDirection.DiagonalMinus,this);
		return super.fnGetEntries();
		
	}
	public List<TicTacToeCell> makeLikeList(List<TicTacToeCell> list, TicTacToeValue valueToMatch){
		return makeLikeList(list,TicTacToeDirection.DiagonalMinus,valueToMatch);
	}
}
