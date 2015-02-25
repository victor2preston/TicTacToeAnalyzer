package TicTacToe;

public class TicTacToePair {

	private final int element0;
	private final int element1;
	
	private final boolean isLeftEdge;
	private final boolean isRightEdge;
	private final boolean isTopEdge;
	private final boolean isBottomEdge;
	
	public static TicTacToePair createPair(int element0, int element1, int size)throws IndexOutOfBoundsException{	
		return new TicTacToePair(element0,element1,size);
	}
	
	public TicTacToePair(int element0, int element1, int size) throws IndexOutOfBoundsException{
		if( size < 1  || (element0 < 0 || element0 >= size) || (element1 < 0 || element1 >= size)){
			throw new IndexOutOfBoundsException("Out of range");
		}
		this.element0 = element0;
		this.element1 = element1;
		this.isLeftEdge = element0 == 0;
		this.isRightEdge = element0 == size - 1;
		this.isTopEdge = element1 == 0;
		this.isBottomEdge = element1 == size - 1;
	}
	
	public Integer getElement0(){
		return element0;
	}
	public Integer getElement1(){
		return element1;
	}
	public boolean isLeftEdge(){
		return this.isLeftEdge;
	}
	public boolean isRightEdge(){
		return this.isRightEdge;
	}
	public boolean isTopEdge(){
		return isTopEdge;
	}
	public boolean isBottomEdge(){
		return isBottomEdge;
	}
	public boolean isLeftCorner(){
		return isLeftEdge && isTopEdge;
	}
	public boolean isRightCorner(){
		return isRightEdge && isTopEdge;
	}

	public TicTacToePair pairCremented(TicTacToeDirection direction, int size){
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
