package TicTacToe;

public enum TicTacToeDirection {
	EastWest(0),
	NorthSouth(1),
	Diagonal(2);
	
	int value;
	
	private TicTacToeDirection(int value){
		this.value = value;
	}
}
