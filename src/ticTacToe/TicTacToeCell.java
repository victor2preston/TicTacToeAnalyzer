package TicTacToe;


public class TicTacToeCell implements LikeFinder{
	
	private TicTacToeValue value;
	private TicTacToeBoard theBoard;
	private TicTacToePair location;
	
	public TicTacToeCell(){
		//Don't allow this, force using the other construction
	}
	
	public TicTacToeCell(TicTacToeValue value, TicTacToeBoard board, int x, int y){
		this.value = value;
		this.theBoard = board;
		this.location = TicTacToePair.createPair(x,y,board.size());
	}

	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){
		//If there are ANY blank cells then another move is possible, so it's not a CatsGame
		//On the other hand, if a winner (X's or O's) HAS been found, the win is good inspite of there being blank cells 
		if(isBlank() && winnerSoFar == TicTacToeResults.CatsGame){
			winnerSoFar = TicTacToeResults.Unfinished;
		}
		return winnerSoFar;
	}
	public int getCount(TicTacToeDirection direction){
		return 0; // do nothing
	}

	public void incrementCount(TicTacToeDirection direction){
		; //do nothing
	}
	
	public TicTacToeValue getValue(){ 
		return this.value;
	}
	public void setValue(TicTacToeValue value){
		this.value = value;
	}
	public boolean isBlank(){
		return this.value == TicTacToeValue.B;
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
	public TicTacToePair getLocation(){
		return location;
	}
	public TicTacToeResults getWinnerType(){
		if(isX()) return TicTacToeResults.WinnerX;
		if(isO()) return TicTacToeResults.WinnerO;
		return TicTacToeResults.CatsGame;
	}
	
	public boolean addLikeEntry(TicTacToeDirection direction, TicTacToeCell rootCell){
		//this function is re-entrant, so we track the rootCell count to make sure we don't
		//enter an infinite loop.
		if(this.matches(rootCell.value)){
			rootCell.incrementCount(direction);
			if(rootCell.getCount(direction) == theBoard.size()){
				return true;  // returns true because this only happens when the count equals the full size; implies a win!
			}
		
			TicTacToePair newLocation = this.location.pairCremented(direction, theBoard.size());
			if(newLocation.getElement0() < theBoard.size() && newLocation.getElement1() < theBoard.size()){
				//theBoard.stream().filter((value != TicTacToeValue.B) && matches(this).addLikeEntry(directoin,rootCell);
				if(!theBoard.getCell(newLocation).isBlank()){
					if(theBoard.getCell(newLocation).matches(this)){
						return theBoard.getCell(newLocation).addLikeEntry(direction,rootCell);
					}
				}
			}
		}
		return false;
	}
}
