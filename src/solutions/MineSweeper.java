package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class MineSweeper {
    private int[] dx = {0,0,1,-1,1,1,-1,-1};
    private int[] dy = {1,-1,0,0,1,-1,1,-1};

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null) {
            return new char[0][0];
        }

        int row = board.length;
        int col = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{click[0], click[1]});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            if(board[x][y] == 'M') {
                board[x][y] = 'X';
                break;
            } else if(board[x][y] == 'E') {
                int count = countMine(board, x, y);
                if(count == 0) {
                    board[x][y] = 'B';
                    for(int i = 0; i < dx.length; i++) {
                        int newX = x + dx[i];
                        int newY = y + dy[i];

                        if(newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length) {
                            if(board[newX][newY] == 'E') {
                                queue.add(new int[]{newX, newY});
                            }
                        }
                    }
                } else {
                    board[x][y] = (char)(count + '0');
                }
            }
        }

        return board;
    }


    private int countMine(char[][] board, int x, int y) {
        int count = 0;
        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length) {
                if(board[newX][newY] == 'M') {
                    count++;
                }
            }
        }

        return count;
    }
}
