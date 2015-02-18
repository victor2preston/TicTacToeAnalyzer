package TicTacToe;


public class TicTacToeCell {
	
	TicTacToeValue value;
	int count = 0;
	TicTacToeDirection direction;
	TicTacToe.TicTacToeBoard theBoard;
	TicTacToePair location;
	
	public TicTacToeCell(TicTacToeValue value, TicTacToeBoard board, int x, int y){
		count = 1;
		this.value = value;
		this.theBoard = board;
		this.location = TicTacToePair.createPair(x,y);
	}

	public TicTacToeValue getValue{ 
		return this.value;
	}
	void setValue(TicTacToeValue value){
		this.value = value;
	}
	
	
	public boolean addLikeEntry(TicTacToeDirection direction){
		count++;
		this.direction = direction;
		
		if(theBoard.getCell(this.location.pairIncremented(direction)).getValue() == value){
			count++;
			if(count++ == theBoard.size)
				return true;
		}
		return false;
	}
}
