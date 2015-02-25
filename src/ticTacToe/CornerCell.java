package TicTacToe;

public abstract class CornerCell extends TicTacToeCell {
	private int countForAcross = 0;
	private int countForDown = 0;
	private int countForDiagonal = 0;
	
	CornerCell(TicTacToeValue value,TicTacToeBoard board,int x, int y){
		super(value,board,x,y);
	}

	public TicTacToeResults getResults(TicTacToeResults winnerSoFar){
		return super.getResults(winnerSoFar);
	}
	
	public int getCount(TicTacToeDirection direction) {
			int result = 0;
			switch(direction){
			case EastWest:
				result = countForAcross;
				break;
			case NorthSouth:
				result = countForDown;
				break;
			case DiagonalPlus:
			case DiagonalMinus:
				result = countForDiagonal;
				break;
			}
			return result;
		}

	public void incrementCount(TicTacToeDirection direction){
		switch(direction){
		case EastWest:
			countForAcross++;
			break;
		case NorthSouth:
			countForDown++;
			break;
		case DiagonalPlus:
		case DiagonalMinus:
			countForDiagonal++;
			break;
		}
	}
}
