package TicTacToe;

import java.util.stream.*;
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
	
	public TicTacToeCell getCell(int x, int y){
		try {
			ArrayList<TicTacToeValue> row = board.get(y);
			return row.get(x);
		}
		catch(IndexOutOfBoundsException e){
			TicTacToeCell edgeCase = new TicTacToeCell(TicTacToeValue.Edge);
			return edgeCase;
		}
	}
	
//	private Array<TicTacToeValue>[8] adjacent(int x, int y){
//		Array<TicTacToeValue>[8] squaresNextTo = {
//				TicTacToeValue.Blank,
//				TicTacToeValue.Blank,
//				TicTacToeValue.Blank,
//				TicTacToeValue.Blank,
//				TicTacToeValue.Blank,
//				TicTacToeValue.Blank,
//				TicTacToeValue.Blank,
//				TicTacToeValue.Blank
//		};
		
		squaresNextTo[0] = board.
		
		return squaresNextTo;
	}
}
