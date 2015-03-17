package TicTacToe;

public class TrialCell extends TicTacToeCell {
	
	private int matchesOnThisRow;
	private int matchesOnThisColumn;
	private int matchesOnThisDiagonal;

	TrialCell(TicTacToeValue value, TicTacToePair location){
		setValue(value);
		setLocation(location);
	}

	public TicTacToeCell fnGetEntries(){
		addLikeEntry(TicTacToeDirection.NorthSouth,this);
		return super.fnGetEntries();
		
	}
	public TicTacToeCell tryCell(){
		addLikeEntry(TicTacToeDirection.EastWest,this);
		addLikeEntry(TicTacToeDirection.WestEast,this);
		addLikeEntry(TicTacToeDirection.NorthSouth,this);
		addLikeEntry(TicTacToeDirection.DiagonalPlus,this);
		return super.fnGetEntries();
	}
}
