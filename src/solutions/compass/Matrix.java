package solutions.compass;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.jianshu.com/p/fdbcba5fe5bc
 * 矩阵题
 */
public class Matrix {
    public void findOneRectangle(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }

        List<int[]> result = new ArrayList<>();


        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 0) {
                    result.add(new int[]{i,j});

                    int height = 1;
                    int width = 1;

                    while(i + height < row && board[i+height][j] == 0) {
                        height++;
                    }

                    while(j+width < col && board[i][j+width] == 0) {
                        width++;
                    }
                    result.add(new int[]{i+height-1, j+width-1});
                    break;
                }

                if(result.size() != 0) {
                    break;
                }
            }
        }
    }


    public void findAllRectangles(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }

        List<int[][]> result = new ArrayList<>();


        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 0) {
                    int[][] rectangle = new int[2][2];
                    rectangle[0][0] = i;
                    rectangle[0][1] = j;
                    
                    board[i][j] = 1;
                    int height = 1;
                    int width = 1;

                    while(i + height < row && board[i+height][j] == 0) {
                        height++;
                    }

                    while(j+width < col && board[i][j+width] == 0) {
                        width++;
                    }

                    for(int h = 0; h < height; h++) {
                        for(int w = 0; w < width; w++) {
                            board[i+h][j+w] = 1;
                        }
                    }
                    rectangle[1][0] = i + height - 1;
                    rectangle[1][1] = i + width - 1;
                    result.add(rectangle);
                }
            }
        }
    }
}
