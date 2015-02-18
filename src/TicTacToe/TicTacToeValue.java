package TicTacToe;


public enum TicTacToeValue {
	X(1),
	Y(2),
	Edge(3),
	Blank(0);
	
	
	private int value;
	private int count = 0; // the number of like elements in a row
	private int direction;
	private boolean counted = false;

	private TicTacToeValue(int value){
		this.value = value;
		this.count = 1;
	}
}
