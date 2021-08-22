package solutions;

/**
 * 999 Available Captures for Rook
 */
public class NumRookCaptures {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    public int numRookCaptures(char[][] board) {
        int x = 0;
        int y = 0;

        int count = 0;

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }

        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            while(newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if(board[newX][newY] == 'p') {
                    count++;
                }
                if(board[newX][newY] != '.'){
                    break;
                }

                newX += dx[i];
                newY += dy[i];
            }
        }

        return count;

    }
}
