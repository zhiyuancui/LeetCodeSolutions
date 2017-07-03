package solutions;

public class BattleshipsInBoard {

	/**
	 * Referencec to: https://discuss.leetcode.com/topic/62970/simple-java-solution/
	 * @param board
	 * @return
	 */
	public int countBattleships(char[][] board) {
        if( board == null || board.length == 0 ) {
		return 0;
	}        

	int row = board.length;
	int column = board[0].length;

	int count = 0;

	for( int i = 0; i < row; i++){
		for(int j = 0; j < column; j++){
			if( board[i][j] == '.' ) continue;

			if( i > 0 && board[i-1][j] == 'X' ) continue;
			if( j > 0 && board[i][j-1] == 'X' ) continue;

			count++;
		}

	}

	return count;
    }
}
