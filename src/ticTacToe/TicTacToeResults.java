package TicTacToe;

//import com.sun.xml.internal.bind.v2.model.core.EnumConstant;

public enum TicTacToeResults {
	WinnerX(1),
	WinnerO(2),
	CatsGame(3),
	Unfinished(0);

	private int value;
	
	private TicTacToeResults(int value){
		this.value = value;
	}
	public String ToString(){
		if(value == 1)
			return "Winner X";
		if(value == 2)
			return "Winner O";
		if(value == 3)
			return "Cats Game";
		if(value == 0)
			return "There are possible moves left!";
		return "A non-value";
	}
}
