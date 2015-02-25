package TicTacToe;


public class TicTacToeCell {
	
	private TicTacToeValue value;
	private int countForAcross;
	private int countForDown;
	private int countForDiagonal;
//	private boolean visitedDown = false;
//	private boolean visitedAcross = false;
//	private boolean visitedDiagonal = false;
	private TicTacToeBoard theBoard;
	private TicTacToePair location;
	
	public TicTacToeCell(TicTacToeValue value, TicTacToeBoard board, int x, int y){
		countForAcross = 0;
		countForDown = 0;
		countForDiagonal = 0;
		this.value = value;
		this.theBoard = board;
		this.location = TicTacToePair.createPair(x,y,board.size());
	}

	public int count(TicTacToeDirection direction){
		int result = 0;
		switch(direction){
		case EastWest:
			result = countForAcross;
			break;
		case NorthSouth:
			result = countForDown;
			break;
		case DiagonalPlus:
		case DiagonalMinus:
			result = countForDiagonal;
			break;
		}
		return result;
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
//		if(count() == theBoard.size()){
			if(isX()) return TicTacToeResults.WinnerX;
			if(isO()) return TicTacToeResults.WinnerO;
//		}
		return TicTacToeResults.CatsGame;
	}
	public void incrementCount(TicTacToeDirection direction){
		switch(direction){
		case EastWest:
			countForAcross++;
			break;
		case NorthSouth:
			countForDown++;
			break;
		case DiagonalPlus:
		case DiagonalMinus:
			countForDiagonal++;
			break;
		}
	}
//	public void visitDown(){
//		this.visitedDown = true;
//	}
//	public void visitAcross(){
//		this.visitedAcross = true;
//	}
//	public void visitDiagonal(){
//		this.visitedDiagonal = true;
//	}
	
	public boolean addLikeEntry(TicTacToeDirection direction, TicTacToeCell rootCell){
		//this function is re-entrant, so we track the rootCell count to make sure we don't
		//enter an infinite loop.
		if(this.matches(rootCell.value)){
			rootCell.incrementCount(direction);
			if(rootCell.count(direction) == theBoard.size()){
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
