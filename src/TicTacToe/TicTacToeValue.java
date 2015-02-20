package TicTacToe;


public enum TicTacToeValue {
	X(1),
	O(2),
	Edge(3),
	Blank(0);
	
	
	private int value;

	private TicTacToeValue(int value){
		this.value = value;
	}
}
