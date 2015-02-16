package TicTacToe;

public enum TicTacToeValue {
	X(1),
	Y(2),
	Blank(0);
	
	
	private int value;

	private TicTacToeValue(int value){
		this.value = value;
	}
}
