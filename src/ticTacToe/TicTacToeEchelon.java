package ticTacToe;

public class TicTacToeEchelon {
	private TicTacToeDirection direction;
	private TicTacToeValue value;
	
	//location of the "root" cell:
	private TicTacToePair location;
	
	private int count;
	
	TicTacToeEchelon(TicTacToeDirection direction){
		this.direction = direction;
		this.value = TicTacToeValue.B;
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
	public boolean isRow(int rowNumber){
		if(direction == TicTacToeDirection.DiagonalMinus | direction == TicTacToeDirection.DiagonalPlus){
			return true;
		}
		return location.getElement0() == rowNumber;
	}
	public boolean isColumn(int columnNumber){
		if(direction == TicTacToeDirection.DiagonalMinus | direction == TicTacToeDirection.DiagonalPlus){
			return true;
		}
		return location.getElement1() == columnNumber;
	}
	public TicTacToeValue getValue(){
		return value;
	}
	public void setValue(TicTacToeValue value){
		this.value = value;
	}
	

}
