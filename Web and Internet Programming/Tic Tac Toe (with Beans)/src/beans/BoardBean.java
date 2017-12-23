package beans;

public class BoardBean {
	private char[] board;
	private int turn;
	private char player;
	private boolean win; //default is false
	private boolean tie;

	public BoardBean() {
		board = new char[] { '-', '-', '-', '-', '-', '-', '-', '-', '-' };
		turn = 0;
		player = 'X';
	}

	public char[] getBoard() {
		return board;
	}

	// we need properties for, message, and the url parameters location and
	// reset
	// parameters will have setters, message needs a getter
	public String getMessage() {
		return tie? "Oh no! It's a tie.": win? "Player " + player + " won!": "Player " + player + "'s turn";
	}

	public void setLocation(int index) {
		if (board[index] == '-' && !win) { //look at the board array index and check if its undescore, or a usable box.
			turn++;
			board[index] = player; // change the index to corresponding player marker

			//columns
			for (int i = 0; i < 3; i++)
				if (board[i] == player && board[i+3] == player && board[i+6] == player)
					win = true;
			//rows
			for (int i = 0; i < 9; i+=3)
				if (board[i] == player && board[i+1] == player && board[i+2] == player)
					win = true;
			//diagonals
			if (board[0] == player && board[4] == player && board[8] == player)
				win = true;
			
			if (board[2] == player && board[4] == player && board[6] == player)
				win = true;
			
			if (turn == 9 && !win)
				tie = true;

			if (!win && !tie)
				player = turn % 2 == 0? 'X': 'O'; // if turn # is even player marker is assigned to X, otherwise O.
		}

	}

	public void setReset(boolean state) {
		for (int i = 0; i < board.length; i++)
			board[i] = '-';
		turn = 0;
		win = state; //state is false because it is declared false in jsp's reset url parameter
		tie = state;
		player = 'X';
	}
}