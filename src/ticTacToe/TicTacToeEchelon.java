package ticTacToe;

import java.util.List;

public class TicTacToeEchelon {
	private TicTacToeDirection direction;
	private TicTacToeValue value;
	private int size;
	private List<TicTacToeCell> echelon;
	
	//location of the "root" cell:
	private TicTacToePair location;
	
	private int count;
	
	TicTacToeEchelon(TicTacToeDirection direction,int size,List<TicTacToeCell> list){
		this.direction = direction;
		this.value = TicTacToeValue.B;
		this.size = size;
		setList(list);
	}
	public List<TicTacToeCell> getList(){
		return echelon;
	}
	public void setList(List<TicTacToeCell> list){
		this.echelon = list;
	}
	
	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
	public TicTacToeDirection getDirection(){
		return direction;
	}
//	public void setDirection(TicTacToeDirection direction){
//		this.direction = direction;
//	}
	public TicTacToePair getLocation(){
		return this.location;
	}
	// returns true if the echelon represents a row that contains the cell(s) that match rowNumber
	public boolean isRow(int rowNumber){
		if(direction == TicTacToeDirection.DiagonalMinus || direction == TicTacToeDirection.DiagonalPlus){
			return true;
		}
		return location.getElement0() == rowNumber;
	}
	// returns true if the echelon represents a column that contains the cell(s) that match the columnNumber
	public boolean isColumn(int columnNumber){
		if(direction == TicTacToeDirection.DiagonalMinus || direction == TicTacToeDirection.DiagonalPlus){
			return true;
		}
		return location.getElement1() == columnNumber;
	}
	// returns true if the cell indicated by x,y is in one of the diagonal echelons
	public boolean isDiagonal(int x, int y){
		if((x == y) || (x == size-y) &&
				(direction == TicTacToeDirection.DiagonalMinus || direction == TicTacToeDirection.DiagonalPlus))
			return true;
		return false;
	}
	
	public boolean matches(TicTacToeValue valueToMatch){
		return this.value == valueToMatch;
	}
	public TicTacToeValue getValue(){
		return value;
	}
	public void setValue(TicTacToeValue value) throws AllreadySetException{
		if(this.value == TicTacToeValue.X || this.value == TicTacToeValue.O){
			throw new AllreadySetException();
		}
		this.value = value;
	}
	public void setToNeither(){
		this.value = TicTacToeValue.Neither;
	}
	

}
