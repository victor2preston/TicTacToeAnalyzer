package TicTacToe;

//import java.util.stream.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TicTacToeBoard {
	
	private int size;

	private ArrayList<ArrayList<TicTacToeCell>> board;

//	public final static TicTacToeCell nullCell = new TicTacToeCell(TicTacToeValue.Null,null,0,0);

	public TicTacToeBoard(int size) throws Exception {
		if(size > TicTacToeMaxSize.MaxSize.value()){
			throw new Exception("Size is too big!");
		}
		this.size = size;
		board = new ArrayList<ArrayList<TicTacToeCell>>();
		
		IntStream.range(0, size).forEach( i -> board.add(new ArrayList<TicTacToeCell>()));
		IntStream.range(0, size).forEach(i -> IntStream.range(0, size).forEach(j -> board.get(j).add(addCellDependingOnLocation(i,j))));
		
	//	IntStream.range(0, size).forEach(i -> board.get(i).stream().forEach(j -> this.addCellDependingOnLocation(i,j)));
				
				
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
	public void setCell(TicTacToeValue value,int x, int y){
		board.get(y).get(x).setValue(value);
	}
	
	public TicTacToeCell getCell(TicTacToePair pair){
		return getCell(pair.getElement0(),pair.getElement1());
	}
	private TicTacToeCell getCell(int x, int y){
			return board.get(y).get(x);
	}
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
	public Optional<TicTacToeCell> nextMove(TicTacToeValue value){
		//TicTacToePair nextPair();
		if(value == TicTacToeValue.O || value == TicTacToeValue.X){
			//TrialCell trialCell = new TrialCell(this.getCell(pair).getValue(), this.getLocation());
			return board.stream().flatMap(row -> row.stream()).filter(cell -> cell.isBlank()).reduce((cell0,cell1) -> cell0.tryCell() ? cell0 : cell1);
		}
		return Optional.of(null); //<TicTacToeCell>.of() ; //new Optional<TicTacToeCell>(TicTacToeValue.B,TicTacToePair.createPair(0,0,this.size));
		
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
}
