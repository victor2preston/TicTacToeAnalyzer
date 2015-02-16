package TicTacToe;

import java.util.ArrayList;



public class TicTacToeBoard {
	
	private int size;

	private ArrayList<ArrayList<TicTacToeValue>> board;
	

	public TicTacToeBoard(int size) throws Exception{
		if(size > TicTacToeMaxSize.MaxSize.value()){
			throw new Exception("Size is too big!");
		}
		
		int i = 0;
		while(i < size){
			
			ArrayList<Integer> row = new ArrayList<Integer>;
			int j = 0;
			while(j < size){
				row.add(TicTacToeValue.Blank);
				j++;
			}
			board.add(new TicTacToeRow(size));
			i++;
		}
		
		
		this.size = size;
		
	}
}
