package ticTacToe;

import java.io.IOException;
import java.util.StringTokenizer;

public class App {
	static int bufferSize = 1024;
	static byte[] inputBuffer = new byte[bufferSize];
	static TicTacToeValue valueOfPlayer = TicTacToeValue.B;
	static TicTacToeValue valueOfMachine = TicTacToeValue.B;
	static TicTacToeBoard thePlayBoard;
	
	//TicTacToeAnalyzer1

	public static void main(String args[]){
		System.out.println("show a sample board, normal size:\n\n");
		
		

		try {
			play();

			//			TicTacToeBoard normalBoard = new TicTacToeBoard(3);
//			
//			normalBoard.setCell(TicTacToeValue.O, 0, 0);
//			normalBoard.setCell(TicTacToeValue.O, 1, 0);
//			//normalBoard.setCell(TicTacToeValue.O, 2, 0);
//			normalBoard.setCell(TicTacToeValue.X, 0, 1);
//			normalBoard.setCell(TicTacToeValue.X, 1, 1);
//			normalBoard.setCell(TicTacToeValue.X, 2, 1);
//			normalBoard.setCell(TicTacToeValue.O, 0, 2);
//			normalBoard.setCell(TicTacToeValue.O, 1, 2);
//			normalBoard.setCell(TicTacToeValue.O, 2, 2);
//	
//			for(ArrayList<TicTacToeCell> row : normalBoard.getBoard()){
//				String displayARow;
//				displayARow = "| ";
//				for(TicTacToeCell cell : row){
//					
//					displayARow += cell.getValue();
//					displayARow += cell.getLocation().getElement0();
//					displayARow += ",";
//					displayARow += cell.getLocation().getElement1();
//					displayARow += " | ";
//				}
//				displayARow += "\n";
//				System.out.println(displayARow);
//			}
//		
//			System.out.println("Now the result:\n");
//			
//			TicTacToeResults results = normalBoard.getResults();
//
//			System.out.println(results.toString());
//			
//			
////			TicTacToeValue tryVal = TicTacToeValue.O;
////			Optional<TicTacToeCell> newCell = normalBoard.nextMove(tryVal);
////			if(newCell.isPresent()){
////				System.out.println("\nThe next cell is:" + newCell.get().getLocation().getElement0() + "," + newCell.get().getLocation().getElement1());
////				System.out.println("and the value is: " + newCell.get().getValue().toString());
////				newCell.get().setValue(tryVal);
////			}
////			else{
////				System.out.println("No next move found");
////			}
//			
//			
//			TicTacToeResults functionalResults = normalBoard.fnGetResults();
//
//			System.out.println("\nAnd the functional result:\n");
//			System.out.println(functionalResults.toString());
//			
//			TicTacToeResults functionalResultsAgain = normalBoard.ffnGetResults();
//
//			System.out.println("\nAnd the alternative functional result:\n");
//			System.out.println(functionalResultsAgain.toString());
//			
//			TicTacToeBoard newBoard = new TicTacToeBoard(6);
//			
//			newBoard.setCell(TicTacToeValue.O, 0, 0);
//			newBoard.setCell(TicTacToeValue.X, 1, 0);
//			newBoard.setCell(TicTacToeValue.O, 2, 0);
//			newBoard.setCell(TicTacToeValue.O, 3, 0);
//			newBoard.setCell(TicTacToeValue.O, 4, 0);
//			newBoard.setCell(TicTacToeValue.O, 5, 0);
//			newBoard.setCell(TicTacToeValue.X, 0, 1);
//			newBoard.setCell(TicTacToeValue.X, 1, 1);
//			newBoard.setCell(TicTacToeValue.X, 2, 1);
//			newBoard.setCell(TicTacToeValue.O, 3, 1);
//			newBoard.setCell(TicTacToeValue.O, 4, 1);
//			newBoard.setCell(TicTacToeValue.O, 5, 1);
//			newBoard.setCell(TicTacToeValue.O, 0, 2);
//			newBoard.setCell(TicTacToeValue.X, 1, 2);
//			newBoard.setCell(TicTacToeValue.X, 2, 2);
//			newBoard.setCell(TicTacToeValue.O, 3, 2);
//			newBoard.setCell(TicTacToeValue.O, 4, 2);
//			newBoard.setCell(TicTacToeValue.O, 5, 2);
//			newBoard.setCell(TicTacToeValue.O, 0, 3);
//			newBoard.setCell(TicTacToeValue.X, 1, 3);
//			newBoard.setCell(TicTacToeValue.O, 2, 3);
//			newBoard.setCell(TicTacToeValue.X, 3, 3);
//			newBoard.setCell(TicTacToeValue.O, 4, 3);
//			newBoard.setCell(TicTacToeValue.X, 5, 3);
//			newBoard.setCell(TicTacToeValue.O, 0, 4);
//			newBoard.setCell(TicTacToeValue.O, 1, 4);
//			newBoard.setCell(TicTacToeValue.O, 2, 4);
//			newBoard.setCell(TicTacToeValue.X, 3, 4);
//			newBoard.setCell(TicTacToeValue.X, 4, 4);
//			newBoard.setCell(TicTacToeValue.O, 5, 4);
//			newBoard.setCell(TicTacToeValue.O, 0, 5);
//			newBoard.setCell(TicTacToeValue.O, 1, 5);
//			newBoard.setCell(TicTacToeValue.O, 2, 5);
//			newBoard.setCell(TicTacToeValue.O, 3, 5);
//			newBoard.setCell(TicTacToeValue.O, 4, 5);
//			newBoard.setCell(TicTacToeValue.X, 5, 5);
//	
//			for(ArrayList<TicTacToeCell> row : newBoard.getBoard()){
//				String displayARow;
//				displayARow = "| ";
//				for(TicTacToeCell cell : row){
//					
//					displayARow += cell.getValue();
//					displayARow += " | ";
//				}
//				displayARow += "\n";
//				System.out.println(displayARow);
//			}
//			System.out.println("Now the result:\n");
//			
//			TicTacToeResults results2 = newBoard.getResults();
//
//			System.out.println(results2.toString());
//
//			TicTacToeResults functionalResults2 = newBoard.fnGetResults();
//
//			System.out.println("\nAnd the functional result:\n");
//			System.out.println(functionalResults2.toString());
			
		}catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
		
	}
	// returns true if the user types in a ^C, meaning they want to stop!
	public static boolean parseInputBuffer(TicTacToeValue value, int x, int y){
		try{
			boolean doLeave = false;
			StringTokenizer inputTokens = new StringTokenizer(new String(inputBuffer));
			if(inputTokens.countTokens() >= 3){ // If there are 3 or more tokens, interpret the first one as the symbol to use, then get x & y, ignore the rest.
				String firstToken =  inputTokens.nextToken();
				switch (firstToken) {
					case "O":
					case "o":
						value = TicTacToeValue.O;
						break;
					case "X":
					case "x":
						value = TicTacToeValue.X;
						break;
					case "^C":
						doLeave = true;
						break;
					default:
						value = TicTacToeValue.B;
						System.out.println("Invalid input");
						throw new NumberFormatException();
					
				}
				if(doLeave)
					return true;
				if(inputTokens.countTokens() >=2){ // If there are only 2 tokens, interpret them as x & y
					x = Integer.parseInt(inputTokens.nextToken());
					y = Integer.parseInt(inputTokens.nextToken());
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Invalid input; " + e.getMessage());
		}
		return false;
	}
	public static void play(){
		boolean play = true;
		boolean continuePlay = true;
		while(play){
			System.out.println("What size board do you want to play on (choose a number between 4 and 1000)?");
			try {
				System.in.read(inputBuffer,0,bufferSize);
			} catch (IOException e1) {
				play = false;
				e1.printStackTrace();
			}
			
			try{
				int size = Integer.parseInt(new String(inputBuffer));
				thePlayBoard = new TicTacToeBoard(size);
				play = false;
//			}catch(NumberFormatException e){
			} catch (Exception e) {
				System.out.println("YOu did not enter anything the systems could interpret as a number!");
				e.printStackTrace();
			}
		}
		play = continuePlay;
		while(play){
			System.out.println("Do you want to be an X or an O?");
			try {
				System.in.read(inputBuffer,0,bufferSize);
			} catch (IOException e1) {
				play = false;
				e1.printStackTrace();
			}
				
//			String inputString = new String(inputBuffer);
			StringTokenizer startToken = new StringTokenizer(new String(inputBuffer));
			if(startToken.equals("^C")){
				play = false;
				continuePlay = false;
			}
			if(startToken.equals("X")){
				play = false;
				valueOfPlayer = TicTacToeValue.X;
				valueOfMachine = TicTacToeValue.O;
			}
			else if(startToken.equals("O")){
				play = false;
				valueOfPlayer = TicTacToeValue.O;
				valueOfMachine = TicTacToeValue.X;
			}
		}

		play = continuePlay;
		while(play){
			try {
				System.in.read(inputBuffer,0,bufferSize);
				TicTacToeValue valueToMatch = valueOfPlayer;
				int x = 0;
				int y = 0;
				if(parseInputBuffer(valueToMatch,x,y)){
					play = false;
					break;
				}
				if(thePlayBoard.isLegalMove(valueToMatch, x, y)){
					if(thePlayBoard.setCell(valueToMatch,x,y)){
						TicTacToeResults results = thePlayBoard.ffnGetResults();
						System.out.println("Result so far is: " + results.ToString());
						if(results == TicTacToeResults.WinnerX || results == TicTacToeResults.WinnerO)
							play = false;
						valueToMatch = valueOfMachine;
						if(thePlayBoard.findMove(valueToMatch,x,y)){
							System.out.println("The system wants to apply " + valueToMatch + " to the cell: " + x + "," + y);
							thePlayBoard.setCell(valueOfMachine, x, y);
							thePlayBoard.display();
						}
					}
				}else{
					System.out.println("try again");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
