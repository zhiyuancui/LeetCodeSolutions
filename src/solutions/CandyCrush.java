package solutions;

/**
 * 732 Candy Crush
 */
public class CandyCrush {
    public int[][] candyCrush(int[][] board) {
        if(board == null || board.length == 0) {
            return new int[0][0];
        }

        int row = board.length;
        int col = board[0].length;

        boolean crush = false;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j +2< col; j++) {
                int value = Math.abs(board[i][j]);
                if(value != 0 && Math.abs(board[i][j+1]) == value && value == Math.abs(board[i][j+2])) {
                    board[i][j] = board[i][j+1] = board[i][j+2] = -value;
                    crush = true;
                }
            }
        }

        for(int i = 0; i + 2 < row; i++) {
            for(int j = 0; j < col; j++) {
                int value = Math.abs(board[i][j]);
                if(value != 0 && Math.abs(board[i+1][j]) == value && value == Math.abs(board[i+2][j])) {
                    board[i][j] = board[i+1][j] = board[i+2][j] = -value;
                    crush = true;
                }
            }
        }


        for(int j = 0; j < col; j++) {
            int last = row - 1;
            for(int i = last; i >= 0; i--) {
                if(board[i][j] > 0) {
                    board[last][j] = board[i][j];
                    last--;
                }
            }
            while(last >= 0) {
                board[last][j] = 0;
                last--;
            }
        }
        return crush ? candyCrush(board) : board;
    }
}
