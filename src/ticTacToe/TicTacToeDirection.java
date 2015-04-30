package ticTacToe;

public enum TicTacToeDirection {
	EastWest(0),
	WestEast(1),
	NorthSouth(2),
	SouthNorth(3),
	DiagonalPlus(4),
	DiagonalMinus(5);
	
	int value;
	
	private TicTacToeDirection(int value){
		this.value = value;
	}
}
