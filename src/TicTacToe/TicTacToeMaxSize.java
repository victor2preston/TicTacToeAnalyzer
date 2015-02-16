package TicTacToe;

public enum TicTacToeMaxSize {
	MaxSize(1000);
	
	int value;
	
	private TicTacToeMaxSize(int size){
		this.value = size;
	}
	public int value(){
		return value;
	}
}
