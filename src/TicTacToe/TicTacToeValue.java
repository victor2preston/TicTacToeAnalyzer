package TicTacToe;


public enum TicTacToeValue {
	X(1),
	O(2),
	Edge(3),
	B(0);
	
	
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
		default:
			result = "bad";
		}
		return result;
	}
}
