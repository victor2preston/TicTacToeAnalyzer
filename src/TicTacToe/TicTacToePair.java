package TicTacToe;

public class TicTacToePair {

	private final Integer element0;
	private final Integer element1;
	
	public static TicTacToePair createPair(Integer element0, Integer element1){		
		return new TicTacToePair(element0,element1);
	}
	
	public TicTacToePair(Integer element0, Integer element1){
		this.element0 = element0;
		this.element1 = element1;
	}
	
	public Integer getElement0(){
		return element0;
	}
	public Integer getElement1(){
		return element0;
	}
	public TicTacToePair pairIncremented(TicTacToeDirection direction){
		switch(direction){
		case EastWest:
			return createPair(element0,element1 + 1);
		case NorthSouth:
			return createPair(element0 + 1,element1);
		case Diagonal:
			return createPair(element0 + 1,element1 + 1);
			default:
				throw new IndexOutOfBoundsException();
		}
		
	}
	public TicTacToePair pairDecremented(TicTacToeDirection direction){
		switch(direction){
		case EastWest:
			return createPair(element0,element1 - 1);
		case NorthSouth:
			return createPair(element0 - 1,element1);
		case Diagonal:
			return createPair(element0 - 1,element1 - 1);
			default:
				throw new IndexOutOfBoundsException();
		}
		
	}
}
