package TicTacToe;

import java.util.ArrayList;

public class App {
	
	//TicTacToeAnalyzer1

	public static void main(String args[]){
		System.out.println("show a sample board, normal size:\n\n");
		
		
		try {
			TicTacToeBoard normalBoard = new TicTacToeBoard(3);
			
			normalBoard.setCell(TicTacToeValue.O, 0, 0);
			normalBoard.setCell(TicTacToeValue.X, 1, 0);
			normalBoard.setCell(TicTacToeValue.O, 2, 0);
			normalBoard.setCell(TicTacToeValue.X, 0, 1);
			normalBoard.setCell(TicTacToeValue.X, 1, 1);
			normalBoard.setCell(TicTacToeValue.X, 2, 1);
			normalBoard.setCell(TicTacToeValue.O, 0, 2);
			normalBoard.setCell(TicTacToeValue.O, 1, 2);
			normalBoard.setCell(TicTacToeValue.O, 2, 2);
	
			for(ArrayList<TicTacToeCell> row : normalBoard.getBoard()){
				String displayARow;
				displayARow = "| ";
				for(TicTacToeCell cell : row){
					
					displayARow += cell.getValue();
					displayARow += cell.getLocation().getElement0();
					displayARow += ",";
					displayARow += cell.getLocation().getElement1();
					displayARow += " | ";
				}
				displayARow += "\n";
				System.out.println(displayARow);
			}
		
			System.out.println("Now the result:\n");
			
			TicTacToeResults results = normalBoard.getResults();

			System.out.println(results.toString());
			
			
			TicTacToeResults functionalResults = normalBoard.fnGetResults();

			System.out.println("\nAnd the functional result:\n");
			System.out.println(functionalResults.toString());
			
			TicTacToeResults functionalResultsAgain = normalBoard.ffnGetResults();

			System.out.println("\nAnd the alternative functional result:\n");
			System.out.println(functionalResultsAgain.toString());
			
			TicTacToeBoard newBoard = new TicTacToeBoard(6);
			
			newBoard.setCell(TicTacToeValue.O, 0, 0);
			newBoard.setCell(TicTacToeValue.X, 1, 0);
			newBoard.setCell(TicTacToeValue.O, 2, 0);
			newBoard.setCell(TicTacToeValue.O, 3, 0);
			newBoard.setCell(TicTacToeValue.O, 4, 0);
			newBoard.setCell(TicTacToeValue.O, 5, 0);
			newBoard.setCell(TicTacToeValue.X, 0, 1);
			newBoard.setCell(TicTacToeValue.X, 1, 1);
			newBoard.setCell(TicTacToeValue.X, 2, 1);
			newBoard.setCell(TicTacToeValue.O, 3, 1);
			newBoard.setCell(TicTacToeValue.O, 4, 1);
			newBoard.setCell(TicTacToeValue.O, 5, 1);
			newBoard.setCell(TicTacToeValue.O, 0, 2);
			newBoard.setCell(TicTacToeValue.X, 1, 2);
			newBoard.setCell(TicTacToeValue.X, 2, 2);
			newBoard.setCell(TicTacToeValue.O, 3, 2);
			newBoard.setCell(TicTacToeValue.O, 4, 2);
			newBoard.setCell(TicTacToeValue.O, 5, 2);
			newBoard.setCell(TicTacToeValue.O, 0, 3);
			newBoard.setCell(TicTacToeValue.X, 1, 3);
			newBoard.setCell(TicTacToeValue.O, 2, 3);
			newBoard.setCell(TicTacToeValue.X, 3, 3);
			newBoard.setCell(TicTacToeValue.O, 4, 3);
			newBoard.setCell(TicTacToeValue.X, 5, 3);
			newBoard.setCell(TicTacToeValue.O, 0, 4);
			newBoard.setCell(TicTacToeValue.O, 1, 4);
			newBoard.setCell(TicTacToeValue.O, 2, 4);
			newBoard.setCell(TicTacToeValue.X, 3, 4);
			newBoard.setCell(TicTacToeValue.X, 4, 4);
			newBoard.setCell(TicTacToeValue.O, 5, 4);
			newBoard.setCell(TicTacToeValue.O, 0, 5);
			newBoard.setCell(TicTacToeValue.O, 1, 5);
			newBoard.setCell(TicTacToeValue.O, 2, 5);
			newBoard.setCell(TicTacToeValue.O, 3, 5);
			newBoard.setCell(TicTacToeValue.O, 4, 5);
			newBoard.setCell(TicTacToeValue.X, 5, 5);
	
			for(ArrayList<TicTacToeCell> row : newBoard.getBoard()){
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
			
			TicTacToeResults results2 = newBoard.getResults();

			System.out.println(results2.toString());

			TicTacToeResults functionalResults2 = newBoard.fnGetResults();

			System.out.println("\nAnd the functional result:\n");
			System.out.println(functionalResults2.toString());
			
		}catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
		
	}
}
