package TicTacToe;

import java.util.ArrayList;

public class App {
	
	//TicTacToeAnalyzer1

	public static void main(String args){
		System.out.println("show a sample board, normal size:\n\n");
		
		
		try {
			TicTacToeBoard normalBoard = new TicTacToeBoard(3);
			
			normalBoard.setCell(TicTacToeValue.O, 0, 0);
			normalBoard.setCell(TicTacToeValue.X, 1, 0);
			normalBoard.setCell(TicTacToeValue.O, 2, 0);
			normalBoard.setCell(TicTacToeValue.X, 0, 1);
			normalBoard.setCell(TicTacToeValue.X, 1, 1);
			normalBoard.setCell(TicTacToeValue.X, 2, 1);
	//		normalBoard.setCell(TicTacToeValue.O, 0, 2);
	//		normalBoard.setCell(TicTacToeValue.O, 1, 2);
	//		normalBoard.setCell(TicTacToeValue.O, 2, 2);
	
			for(ArrayList<TicTacToeCell> row : normalBoard.getBoard()){
				String displayARow;
				displayARow = "| ";
				for(TicTacToeCell cell : row){
					
					displayARow += cell.getValue();
					displayARow += " | ";
				}
				displayARow += "\n";
				System.out.println(displayARow);
			}
			System.out.println("Now the result:\n");
			
			TicTacToeResults results = normalBoard.nfGetResults();

			System.out.println(results.toString());
			
		}catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
		
	}
}
