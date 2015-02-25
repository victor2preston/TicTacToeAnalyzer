package TicTacToe;

//import java.util.stream.*;
import java.util.ArrayList;




public class TicTacToeBoard {
	
	private int size;

	private ArrayList<ArrayList<TicTacToeCell>> board;

	public TicTacToeBoard(int size) throws Exception {
		if(size > TicTacToeMaxSize.MaxSize.value()){
			throw new Exception("Size is too big!");
		}
		this.size = size;
		board = new ArrayList<ArrayList<TicTacToeCell>>();
		
		int i = 0;
		while(i < size){
			
			ArrayList<TicTacToeCell> row = new ArrayList<TicTacToeCell>(size);
			int j = 0;
			while(j < size){
				row.add(new TicTacToeCell(TicTacToeValue.B,this,j,i));
				j++;
			}
			board.add(row);
			i++;
		}
		
		
		
	}
	public void setCell(TicTacToeValue value,int x, int y){
//		if(x >= size || y >= size){
//			throw new IndexOutOfBoundsException("Out of bounds exception");
//		}
		board.get(y).get(x).setValue(value);
//		getCell(x,y).setValue(value);
	}
	
	public TicTacToeCell getCell(TicTacToePair pair){
		return getCell(pair.getElement0(),pair.getElement1());
	}
	private TicTacToeCell getCell(int x, int y){
//		try {
//			
			return board.get(y).get(x);
//			ArrayList<TicTacToeCell> row = board.get(location.getElement1());
//			return row.get(location.getElement0());
//		}
//		catch(IndexOutOfBoundsException e){
//			TicTacToeCell edgeCase = new TicTacToeCell(TicTacToeValue.Edge,null,0,0);
//			return edgeCase;
//		}
	}
	public TicTacToeResults getResult(TicTacToeCell currentCell){
		
//			if(board.stream().flatMap( row -> stream.of(cell -> cell.matches(currentCell)).reduce(currentCell.getValue())){
			if(false){  //Not ready for Prime Time!
				if(currentCell.getValue() == TicTacToeValue.X)
					return TicTacToeResults.WinnerX;
				else
					return TicTacToeResults.WinnerO;
			}
			else {
				return TicTacToeResults.CatsGame;
			}
		}
	public TicTacToeResults nfGetResults(){
		TicTacToeResults winner = TicTacToeResults.CatsGame;
		for( ArrayList<TicTacToeCell> row : board){
			for( TicTacToeCell cell : row){
				if(cell.getLocation().isLeftCorner()){
					if(cell.addLikeEntry(TicTacToeDirection.EastWest,cell)){
						winner = cell.getWinnerType();
					}
					if(cell.addLikeEntry(TicTacToeDirection.NorthSouth,cell)){
						winner = cell.getWinnerType();
					}
					if(cell.addLikeEntry(TicTacToeDirection.DiagonalPlus,cell)){
						winner = cell.getWinnerType();
					}
				}
				else if(cell.getLocation().isRightCorner()){
					if(cell.addLikeEntry(TicTacToeDirection.NorthSouth,cell)){
						winner = cell.getWinnerType();
					}
					if(cell.addLikeEntry(TicTacToeDirection.DiagonalMinus,cell)){
						winner = cell.getWinnerType();
					}
				}
				else if(cell.getLocation().isTopEdge()){
					if(cell.addLikeEntry(TicTacToeDirection.NorthSouth,cell)){
						winner = cell.getWinnerType();
					}
				 }
				else if(cell.getLocation().isLeftEdge()){
					if(cell.addLikeEntry(TicTacToeDirection.EastWest,cell)){
						winner = cell.getWinnerType();
					}
				}
				else {
					//If there are ANY blank cells then another move is possible, so it's not a CatsGame
					//On the other hand, if a winner (X's or O's) HAS been found, the win is good inspite of there being blank cells 
					if(cell.isBlank() && winner == TicTacToeResults.CatsGame){
						winner = TicTacToeResults.Unfinished;
					}
				}
			}
		}
		return winner;
	}
	public int size(){
		return size;
	}
	

	public ArrayList<ArrayList<TicTacToeCell>> getBoard() {
		return board;
	}
	
		
}
