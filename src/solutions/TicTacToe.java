package solutions;


/**
 * 348 Design Tic-Tac-Toe
 */
public class TicTacToe {

	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
	    rows = new int[n];
	    cols = new int[n];
	}

	/** Player {player} makes a move at ({row}, {col}).
	    @param row The row of the board.
	    @param col The column of the board.
	    @param player The player, can be either 1 or 2.
	    @return The current winning condition, can be either:
	            0: No one wins.
	            1: Player 1 wins.
	            2: Player 2 wins. */
	public int move(int row, int col, int player) {
	    int toAdd = player == 1 ? 1 : -1;

	    rows[row] += toAdd;
	    cols[col] += toAdd;
	    if (row == col)
	    {
	        diagonal += toAdd;
	    }

	    if (col == (cols.length - row - 1))
	    {
	        antiDiagonal += toAdd;
	    }

	    int size = rows.length;
	    if (Math.abs(rows[row]) == size ||
	        Math.abs(cols[col]) == size ||
	        Math.abs(diagonal) == size  ||
	        Math.abs(antiDiagonal) == size)
	    {
	        return player;
	    }

	    return 0;
	}
}
