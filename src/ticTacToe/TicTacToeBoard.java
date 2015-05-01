

package ticTacToe;

import java.util.stream.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class TicTacToeBoard {
	
	private int size;

	private ArrayList<ArrayList<TicTacToeCell>> board;

//	private class State {
//		public int number;
//		public TicTacToeValue value;
//		
//		State(int number,TicTacToeValue value){
//			this.number = number;
//			this.value = value;
//		}
//		// This is surprisingly complex: if the value in the cell is either X or O, AND not already set, then set the State to the cell value
//		// If it IS already set (and it's not the SAME value), then we need to set the State to "Neither" and return false
//		
//		public boolean setCell(TicTacToeCell cell){
//			if(cell.getValue().equals(TicTacToeValue.X) || cell.getValue().equals(TicTacToeValue.O)) 
//				if(this.value.equals(cell.getValue()))
//					return true;
//				if(this.value.equals(TicTacToeValue.B)){
//					this.value = cell.getValue();
//					return true;
//				}
//				else{
//					this.value = TicTacToeValue.Neither;
//					return false;
//				}
//			}
//		public void setValue(TicTacToeValue value){
//			this.value = value;
//		}
//	}
//	static public TicTacToeValue decideState(List<TicTacToeCell> list){
//		TicTacToeValue valueX = TicTacToeValue.X;
//		TicTacToeValue valueO = TicTacToeValue.O;
//		
//		long numberOfXValues = 0;
//		long numberOfOValues = 0;
////		List<TicTacToeCell> list = new ArrayList<TicTacToeCell>();
//		
////		list.addAll((Collection<? extends TicTacToeCell>) board.stream());;
//		numberOfXValues = numberOfAlreadySetValues( list,valueX);
//		numberOfOValues = numberOfAlreadySetValues( list,valueO);
//		
//		if(numberOfXValues > 0 && numberOfOValues > 0){
//			 return TicTacToeValue.Neither;
//		}
//		else if(numberOfXValues > 0){
//			return TicTacToeValue.X;
//		}
//		else if(numberOfOValues > 0){
//			return TicTacToeValue.O;
//		}
//		return TicTacToeValue.B;
//	}
	
	//These arrays contain the "state" of each possible winning row, column, or one of the two diagonals,
	//
//	private ArrayList<State> rowState;
	private List<TicTacToeEchelon> echelons; //the entire list of all possible rows, columns and diagonals 
	
	
//	private ArrayList<Integer> rowState;
//	private TicTacToeValue rowValue;
//	private ArrayList<Integer> columnState;
//	private TicTacToeValue columnValue;
//	private ArrayList<Integer> diagonalState;
//	private TicTacToeValue diagonalValue;

	public TicTacToeBoard(int size) throws Exception {
		if(size > TicTacToeMaxSize.MaxSize.value()){
			throw new Exception("Size is too big!");
		}
		this.size = size;
		board = new ArrayList<ArrayList<TicTacToeCell>>();
		
		IntStream.range(0, size).forEach( i -> board.add(new ArrayList<TicTacToeCell>()));
		IntStream.range(0, size).forEach(i -> IntStream.range(0, size).forEach(j -> board.get(j).add(addCellDependingOnLocation(i,j))));
		
	//	IntStream.range(0, size).forEach(i -> board.get(i).stream().forEach(j -> this.addCellDependingOnLocation(i,j)));

		makeEchelonList(size);
//		establishState();
				
	}
	private TicTacToeCell  addCellDependingOnLocation(int x, int y){
		if(x == 0){
			if( y == 0)
				return new LeftCornerCell(TicTacToeValue.B,this,x,y);
			else
				return new LeftEdgeCell(TicTacToeValue.B,this,x,y);
		}
		else if(y == 0){
			if( x == size - 1)
				return new RightCornerCell(TicTacToeValue.B,this,x,y);
			else
				return new UpperEdgeCell(TicTacToeValue.B,this,x,y);
		}
		else
			return new TicTacToeCell(TicTacToeValue.B,this,x,y);
	}
	//Add an echelon for each possible row, column, or diagonal
	private void makeEchelonList(int size){

		echelons = new ArrayList<TicTacToeEchelon>();
		board.stream().forEach(row -> {
			TicTacToeEchelon newEchelon = new TicTacToeEchelon(TicTacToeDirection.EastWest,size,row);
			echelons.add(newEchelon);
		});

		IntStream.range(0, size).forEach( i -> {
					ArrayList<TicTacToeCell> verticalList = new ArrayList<TicTacToeCell>();
					IntStream.range(0, size).forEach(j -> verticalList.add(this.getCell(i, i)));
					echelons.add( new TicTacToeEchelon(TicTacToeDirection.NorthSouth,size,verticalList));
				});
		ArrayList<TicTacToeCell> diagonalList = new ArrayList<TicTacToeCell>();
		IntStream.range(0, size).forEach(i -> {
				diagonalList.add(this.getCell(i,i));
		});	
		echelons.add( new TicTacToeEchelon(TicTacToeDirection.DiagonalPlus,size,diagonalList));
		ArrayList<TicTacToeCell> reverseDiagonalList = new ArrayList<TicTacToeCell>();
		IntStream.range(0, size).forEach(i -> {
			reverseDiagonalList .add(this.getCell(i,(size - 1) - i));
		});	
		echelons.add( new TicTacToeEchelon(TicTacToeDirection.DiagonalMinus,size,reverseDiagonalList ));
	}
	public List<TicTacToeEchelon> getEchelonList(){
		return echelons;
	}
	public boolean setCell(TicTacToeValue value,int x, int y) throws AllreadySetException {
		board.get(y).get(x).setValue(value);
		getEchelonList().stream()
				  .filter(echelon -> echelon.isRow(x) || echelon.isColumn(y))
				  .forEach(echelon -> echelon.setValue(value));
		return true;
	}
	public boolean isLegalMove(TicTacToeValue valueToMatch, int x, int y){
		boolean isLegal = getEchelonList().stream()
							.filter(echelon -> echelon.isRow(x) || echelon.isColumn(y) || echelon.isDiagonal(x,y))
							.allMatch(echelon -> (echelon.matches(valueToMatch) || echelon.getValue() == TicTacToeValue.B));
		return isLegal;
	}
	
	public TicTacToeCell getCell(TicTacToePair pair){
		return getCell(pair.getElement0(),pair.getElement1());
	}
	private TicTacToeCell getCell(int x, int y){
			return board.get(y).get(x);
	}
//	public List<State> getRowState(){
//		return rowState;
//	}
//	public State getRowState(int index){
//		return this.getRowState().get(index);
//	}
//	public TicTacToeValue getRowValue(int row){
//		return rowValue;
//	}
//	public List<Integer> getColumnState(){
//		return columnState;
//	}
//	public TicTacToeValue getColumnValue(int column){
//		return columnValue;
//	}
//	public List<Integer> getDiagonalState(){
//		return diagonalState;
//	}
//	public TicTacToeValue getDiagonalValue(int diagonal){
//		return diagonalValue;
//	}
	public TicTacToeResults fnGetResults(){

		reset();
		TicTacToeResults winner = TicTacToeResults.CatsGame;
		TicTacToeCell nullCell = new TicTacToeCell(TicTacToeValue.Null,this,0,0); 
		try{
			TicTacToeCell resultCell = 
					board.stream().flatMap(row -> row.stream())
						.map(TicTacToeCell::fnGetEntries) //cell -> cell.fnGetEntries())
						.reduce(nullCell, TicTacToeCell::reduceFunction); // (cell0,cell1) -> reduceFunction(cell0,cell1)); //(cell0,cell1) -> (cell1.getCount(null) == board.size() ? cell1 : nullCell));
			//if(resultCell.isPresent()){
				System.out.println("resultCell = " + resultCell.toString() + ", value = " + resultCell.getValue().toString());
				winner = resultCell.getWinnerType();
			//}
		}catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
		return winner;
	}
	public TicTacToeResults ffnGetResults(){

		reset();
		TicTacToeResults winner = TicTacToeResults.CatsGame;
		TicTacToeCell nullCell = new TicTacToeCell(TicTacToeValue.Null,this,0,0); 
		try{
			TicTacToeCell resultCell = 
					board.stream().flatMap(row -> row.stream())
						.reduce(nullCell,TicTacToeCell::fnBiFunc,TicTacToeCell::reduceFunction); // nullCell,(cell0,cell1) -> (cell1.getCount(null) == board.size() ? cell1 : nullCell),(cell0,cell1) -> cell0.fnGetEntries());
			winner = resultCell.getWinnerType();
		}catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
		return winner;
	}
	public TicTacToeResults fGetResults(){
		TicTacToeResults winner = TicTacToeResults.CatsGame;
		for( ArrayList<TicTacToeCell> row : board){
			for( TicTacToeCell cell : row){
				winner = cell.getResults(winner);
			}
		}
		return winner;
	}
	public boolean findMove(TicTacToeValue valueToMatch,int x, int y){
		//TicTacToePair nextPair();
		if(valueToMatch == TicTacToeValue.O || valueToMatch == TicTacToeValue.X){
			Optional<TicTacToeEchelon> matchingEchelonWithHighestCount = getEchelonList().stream()
					.filter(echelon -> echelon.matches(valueToMatch))
					.reduce((echelon1,echelon2) -> echelon1.getCount() > echelon2.getCount() ? echelon1 : echelon2);
			if(matchingEchelonWithHighestCount.isPresent()){
				x = matchingEchelonWithHighestCount.get().getLocation().getElement0();
				y = matchingEchelonWithHighestCount.get().getLocation().getElement1();
			}else{
				return false;
			}
			
		}
		return true;
		
	}
	public TicTacToeResults getResults(){
		TicTacToeResults winner = TicTacToeResults.CatsGame;
		for( ArrayList<TicTacToeCell> row : board){
			for( TicTacToeCell cell : row){
				winner = cell.getResults(winner);
			}
		}
		return TicTacToeResults.Unfinished;
	}
	
//	public TicTacToeResults nfGetResults(){
//		TicTacToeResults winner = TicTacToeResults.CatsGame;
//		for( ArrayList<TicTacToeCell> row : board){
//			for( TicTacToeCell cell : row){
//				if(cell.getLocation().isLeftCorner()){
//					if(cell.addLikeEntry(TicTacToeDirection.EastWest,cell)){
//						winner = cell.getWinnerType();
//					}
//					if(cell.addLikeEntry(TicTacToeDirection.NorthSouth,cell)){
//						winner = cell.getWinnerType();
//					}
//					if(cell.addLikeEntry(TicTacToeDirection.DiagonalPlus,cell)){
//						winner = cell.getWinnerType();
//					}
//				}
//				else if(cell.getLocation().isRightCorner()){
//					if(cell.addLikeEntry(TicTacToeDirection.NorthSouth,cell)){
//						winner = cell.getWinnerType();
//					}
//					if(cell.addLikeEntry(TicTacToeDirection.DiagonalMinus,cell)){
//						winner = cell.getWinnerType();
//					}
//				}
//				else if(cell.getLocation().isTopEdge()){
//					if(cell.addLikeEntry(TicTacToeDirection.NorthSouth,cell)){
//						winner = cell.getWinnerType();
//					}
//				 }
//				else if(cell.getLocation().isLeftEdge()){
//					if(cell.addLikeEntry(TicTacToeDirection.EastWest,cell)){
//						winner = cell.getWinnerType();
//					}
//				}
//				else {
//					//If there are ANY blank cells then another move is possible, so it's not a CatsGame
//					//On the other hand, if a winner (X's or O's) HAS been found, the win is good inspite of there being blank cells 
//					if(cell.isBlank() && winner == TicTacToeResults.CatsGame){
//						winner = TicTacToeResults.Unfinished;
//					}
//				}
//			}
//		}
//		return winner;
//	}
	public int size(){
		return size;
	}
	

	public ArrayList<ArrayList<TicTacToeCell>> getBoard() {
		return board;
	}

	public ArrayList<TicTacToeCell> getRow(int j){
		return board.get(j);
	}

	private void reset(){
		board.stream().flatMap(row -> row.stream()).forEach(cell -> cell.resetCount());
	}
//	public void establishState(){
//		board.stream().forEachOrdered(row -> getRowState().add(new State(0,TicTacToeValue.B)));
//		board.stream().findAny().ifPresent(cell -> rowState.add(new State(0,TicTacToeValue.B)));   //flatMap(row -> row.stream().findFirst().ifPresent(row) ? row.get().stream();
//		rowState.add(new State(0,TicTacToeValue.B));
//		rowState.add(new State(0,TicTacToeValue.B));
//	}	
	static public long numberOfAlreadySetValues(List<TicTacToeCell> list, TicTacToeValue value){
		return list.stream()
					.filter(cell -> cell.getValue().equals(value))
					.count();
	}
	public void display(){
		
		board.stream()
				.forEach(row -> {
					StringBuffer buffer = new StringBuffer();
					row.stream().forEach(cell -> buffer.append(cell.getValue()));
					buffer.append("\n");
					System.out.println(buffer);
				});
					
//		for(ArrayList<TicTacToeCell> row : board.getBoard()){
//			String displayARow;
//			displayARow = "| ";
//			for(TicTacToeCell cell : row){
//				
//				displayARow += cell.getValue();
//				displayARow += " | ";
//			}
//			displayARow += "\n";
//			System.out.println(displayARow);
//		}
		
	}
	
//	public long numberOfAlreadySetValues(List<TicTacToeCell> list){
//
//		TicTacToeValue value = TicTacToeValue.B;
//		return list.stream()
////				.forEach(cell -> cell.getValue() )
//				.filter(cell -> cell.getValue().equals(value))
//				.count();
//	}
//	public void decideStates() {
//		//set state for each of the rows:
//		getBoard().stream().forEach(row -> getRowState().stream().forEach(state -> state.decideState(row)));
//		//then for each of the columns:
//		getBoard().stream().flatMap(row -> row.stream()).
////		getRowState().stream().forEach(state -> getBoard().stream().flatMap(row -> row.stream()).forEach(cell -> state.setValue(cell)));
//	}
//	public void setStates(){
//		TicTacToeValue state = TicTacToeValue.B;
//		Map<Integer,List<TicTacToeCell>> arrayOfRows = getBoard().stream()
//															.flatMap(row -> row.stream())
//															.collect(Collectors.groupingBy(TicTacToeCell::typeRow));
////															.
////															.forEach(entry -> System.println("key: " + entry.getKey() + "value: " + entry.getValue())); //compute(arg0, TicTacToeCell::decideState)
//		arrayOfRows.forEach(cellSet -> rowState.add(decideState(cellSet)));
//		
//		//arrayOfCells.addAll(getBoard().stream().flatMap(row -> row.stream()).collect(Collectors.groupingBy(TicTacToeCell::typeColummn)));
//		//decideState(arrayOfCells);
//		//getRowState().stream().forEach(state -> state.decideState());
//		
//		
//	}
}
