package ticTacToe;


public enum TicTacToeValue {
	B(0),
	X(1),
	O(2),
	Edge(3),
	Neither(4),
	Null(5);
	
	
	private int value;

	private TicTacToeValue(int value){
		this.value = value;
	}
	public String toString(){
		String result;
		switch(this.value){
		case 0:
			result = "B";
			break;
		case 1:
			result = "X";
			break;
		case 2:
			result = "O";
			break;
		case 3:
			result = "Edge";
			break;
		case 4:
			result = "Neither";
			break;
		case 5:
			result = "Null";
			break;
		
		default:
			result = "bad";
		}
		return result;
	}
}
