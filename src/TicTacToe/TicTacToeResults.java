package TicTacToe;

//import com.sun.xml.internal.bind.v2.model.core.EnumConstant;

public enum TicTacToeResults {
	WinnerX(1),
	WinnerO(2),
	CatsGame(3);

	private int value;
	
	private TicTacToeResults(int value){
		this.value = value;
	};
}
