package TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;


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
		if(board != null)
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
	public TicTacToeCell fGetResults(TicTacToeResults winnerSoFar){
		//If there are ANY blank cells then another move is possible, so it's not a CatsGame
		//On the other hand, if a winner (X's or O's) HAS been found, the win is good inspite of there being blank cells 
		if(isBlank() && winnerSoFar == TicTacToeResults.CatsGame){
			winnerSoFar = TicTacToeResults.Unfinished;
		}
		return this;
	}
	public TicTacToeCell fnGetResults(TicTacToeCell rootCell){
		//If there are ANY blank cells then another move is possible, so it's not a CatsGame
		//On the other hand, if a winner (X's or O's) HAS been found, the win is good inspite of there being blank cells 
		if(isBlank() && rootCell.isX()){
			rootCell.setValue(TicTacToeValue.B);
		}
		return this;
	}
	public TicTacToeCell fnGetEntries(){
		return this;
	}
	public TicTacToeCell ffnGetEntries(Object cell0,Object cell1){
		return fnGetEntries();
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
	public boolean isNull(){
		return this.value == TicTacToeValue.Null;
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
	public void setLocation(TicTacToePair location){
		this.location = location;
	}
	public TicTacToeResults getWinnerType(){
		if(isX()) return TicTacToeResults.WinnerX;
		if(isO()) return TicTacToeResults.WinnerO;
		if(isNull()) return TicTacToeResults.Unfinished;
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
			TicTacToePair newLocation; 
			try{
				newLocation = this.location.pairCremented(direction, theBoard.size());
			}catch(IndexOutOfBoundsException e){
				return false;
			}
			//if(!theBoard.getCell(newLocation).isBlank()){
				if(theBoard.getCell(newLocation).matches(this)){
					return theBoard.getCell(newLocation).addLikeEntry(direction,rootCell);
				}
			//}
		}
		return false;
	}
	public void resetCount(){}
	public TicTacToeBoard getBoard(){
		return this.theBoard;
	}
	public int tryCell(TicTacToeValue valueToMatch){
		TrialCell trialCell = new TrialCell(valueToMatch,this.getLocation());
		List<Integer> allCounts = new ArrayList<Integer>();
		
		addLikeEntry(TicTacToeDirection.EastWest,trialCell);
		addLikeEntry(TicTacToeDirection.WestEast,trialCell);
		allCounts.add(trialCell.getCount(TicTacToeDirection.EastWest));

		addLikeEntry(TicTacToeDirection.NorthSouth,trialCell);
		addLikeEntry(TicTacToeDirection.SouthNorth,trialCell);
		allCounts.add(trialCell.getCount(TicTacToeDirection.NorthSouth));

		addLikeEntry(TicTacToeDirection.DiagonalPlus,trialCell);
		addLikeEntry(TicTacToeDirection.DiagonalMinus,trialCell);
		allCounts.add(trialCell.getCount(TicTacToeDirection.DiagonalPlus));
		Optional<Integer> result = allCounts.stream().max(null);
		if(result.isPresent())
			return result.get();
		else
			return 0;
	}
	public TicTacToeCell ffnReduceFunction(Object cell0,Object cell1){
		return fnGetEntries();
	}
	static public TicTacToeCell reduceFunction(TicTacToeCell arg0, TicTacToeCell arg1){
		System.out.println("Output of reduceFunction for: " + arg0.toString() + " and " + arg1.toString() );
		System.out.println("nullCell = " + arg0.toString() + " value: " + arg0.getValue().toString());
		
		TicTacToeCell resultCell = (arg0.getBoard().size() == arg1.getCount(null) ? arg1 : arg0);
		System.out.println(resultCell.getValue() + " count: " + resultCell.getCount(null));
		return resultCell;
	}
	
	static public TicTacToeCell fnBiFunc(TicTacToeCell cell0, TicTacToeCell cell1){ //BiFunction<TicTacToeCell,TicTacToeCell,TicTacToeCell> bi, TicTacToeCell cell0, TicTacToeCell cell1){
		//TicTacToeCell temp = new TicTacToeCell(TicTacToeValue.Null,null,0,0);
		cell1.fnGetEntries();
		return cell1; //(TicTacToeCell)temp.apply(cell0, cell1);
	}
}
