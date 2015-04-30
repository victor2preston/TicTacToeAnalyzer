package ticTacToe;

public class TicTacToePair {

	private final int element0;
	private final int element1;
	
	public static TicTacToePair createPair(int element0, int element1, int size)throws IndexOutOfBoundsException{	
		return new TicTacToePair(element0,element1,size);
	}
	
	public TicTacToePair(int element0, int element1, int size) throws IndexOutOfBoundsException{
		if( size < 1  || (element0 < 0 || element0 > size) || (element1 < 0 || element1 > size)){
			throw new IndexOutOfBoundsException("Out of range");
		}
		this.element0 = element0;
		this.element1 = element1;
	}
	
	public Integer getElement0(){
		return element0;
	}
	public Integer getElement1(){
		return element1;
	}

	public TicTacToePair pairCremented(TicTacToeDirection direction, int size) throws IndexOutOfBoundsException{
		switch(direction){
		case EastWest:
			return createPair(element0 + 1,element1, size);
		case WestEast: //not needed
			return createPair(element0 - 1,element1, size);
		case NorthSouth:
			return createPair(element0,element1 + 1, size);
		case SouthNorth:  //not needed
			return createPair(element0 - 1,element1, size);
		case DiagonalPlus:
			return createPair(element0 + 1,element1 + 1, size);
		case DiagonalMinus:
			return createPair(element0 - 1,element1 + 1, size);
			default:
				throw new IndexOutOfBoundsException();
		}
		
	}
}
