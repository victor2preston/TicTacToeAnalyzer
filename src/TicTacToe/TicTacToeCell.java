package TicTacToe;


public class TicTacToeCell {
	
	private TicTacToeValue value;
	private int count = 0;
	private boolean visited = false;
//	private TicTacToeDirection direction;
	private TicTacToeBoard theBoard;
	private TicTacToePair location;
	
	public TicTacToeCell(TicTacToeValue value, TicTacToeBoard board, int x, int y){
		count = 1;
		this.value = value;
		this.theBoard = board;
		this.location = TicTacToePair.createPair(x,y);
	}

	public TicTacToeValue getValue(){ 
		return this.value;
	}
	public void setValue(TicTacToeValue value){
		this.value = value;
	}
	public boolean isBlank(){
		return this.value == TicTacToeValue.Blank;
	}
	public boolean isX(){
		return this.value == TicTacToeValue.X;
	}
	public boolean isO(){
		return this.value == TicTacToeValue.O;
	}
	public boolean matches(TicTacToeValue match){
		return this.value == match;
	}
	public boolean matches(TicTacToeCell match){
		return this.value == match.getValue();
	}
	public TicTacToeResults getWinnerType(){
		if(count == theBoard.size()){
			if(isX()) return TicTacToeResults.WinnerX;
			if(isO()) return TicTacToeResults.WinnerO;
		}
		return TicTacToeResults.CatsGame;
	}
	public int getCount(){
		return this.count;
	}
	public void incrementCount(){
		this.count++;
	}
	public void visit(){
		this.visited = true;
	}
	
	public boolean addLikeEntry(TicTacToeDirection direction, TicTacToeCell rootCell){
		//this function is re-entrant, so we track the rootCell count to make sure we don't
		//enter an infinite loop.
		if(!visited){
			visit();
			if(this.matches(TicTacToeValue.X) || matches(TicTacToeValue.O)){
				rootCell.incrementCount();
				if(rootCell.getCount() == theBoard.size()){
					return true;  // returns true because this only happens when the count equals the full size
				}
			
				TicTacToeCell newCell = theBoard.getCell(this.location.pairIncremented(direction));
				if(!newCell.isBlank()){
					if(newCell.matches(this)){
						newCell.addLikeEntry(direction,rootCell);
					}
				}
			}
		}
		return false;
	}
}
