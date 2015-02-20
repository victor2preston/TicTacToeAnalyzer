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
		board = new ArrayList<ArrayList<TicTacToeCell>>();
		
		int i = 0;
		while(i < size){
			
			ArrayList<TicTacToeCell> row = new ArrayList<TicTacToeCell>(size);
			int j = 0;
			while(j < size){
				row.add(new TicTacToeCell(TicTacToeValue.Blank,this,i,j));
				j++;
			}
			board.add(row);
			i++;
		}
		
		
		this.size = size;
		
	}
	public void setCell(TicTacToeValue value,int x, int y){
		getCell(TicTacToePair.createPair(x,y)).setValue(value);
	}
	
	public TicTacToeCell getCell(TicTacToePair location){
		try {
			ArrayList<TicTacToeCell> row = board.get(location.getElement1());
			return row.get(location.getElement0());
		}
		catch(IndexOutOfBoundsException e){
			TicTacToeCell edgeCase = new TicTacToeCell(TicTacToeValue.Edge,null,0,0);
			return edgeCase;
		}
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
		for( ArrayList<TicTacToeCell> row : board){
			for( TicTacToeCell cell : row){
				if(cell.addLikeEntry(TicTacToeDirection.EastWest,cell)){
					return cell.getWinnerType();
				}
				if(cell.addLikeEntry(TicTacToeDirection.NorthSouth,cell)){
					return cell.getWinnerType();
				}
				if(cell.addLikeEntry(TicTacToeDirection.Diagonal,cell)){
					return cell.getWinnerType();
				}
				
			}
		}
		return TicTacToeResults.Unfinished;
	}
	public int size(){
		return size;
	}
	

	public ArrayList<ArrayList<TicTacToeCell>> getBoard() {
		return board;
	}
	
		
}
