package ticTacToe;

import java.util.List;


public class LeftCornerCell extends CornerCell{
	
	LeftCornerCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}
	//Override
	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){
	
		if(addLikeEntry(TicTacToeDirection.EastWest,this)){
			winnerSoFar = getWinnerType();
		}
		if(addLikeEntry(TicTacToeDirection.NorthSouth,this)){
			winnerSoFar = getWinnerType();
		}
		if(addLikeEntry(TicTacToeDirection.DiagonalPlus,this)){
			winnerSoFar = getWinnerType();
		}
		return super.getResults(winnerSoFar);
	}

	public TicTacToeCell fGetResults(TicTacToeResults winnerSoFar){
		
		if(addLikeEntry(TicTacToeDirection.EastWest,this)){
			winnerSoFar = getWinnerType();
		}
		if(addLikeEntry(TicTacToeDirection.NorthSouth,this)){
			winnerSoFar = getWinnerType();
		}
		if(addLikeEntry(TicTacToeDirection.DiagonalPlus,this)){
			winnerSoFar = getWinnerType();
		}
		return super.fGetResults(winnerSoFar);
	}
	public TicTacToeCell fnGetEntries(){
		addLikeEntry(TicTacToeDirection.EastWest,this);
		addLikeEntry(TicTacToeDirection.NorthSouth,this);
		addLikeEntry(TicTacToeDirection.DiagonalPlus,this);
		return super.fnGetEntries();
	}
	public List<TicTacToeCell> makeLikeList(List<TicTacToeCell> list, TicTacToeValue valueToMatch){
		return makeLikeList(list,TicTacToeDirection.DiagonalPlus,valueToMatch);
	}

}



