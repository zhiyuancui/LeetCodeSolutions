package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 417 Pacific Atlantic Water Flow
 */
public class PacificAtlantic {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] pacific = new int[row][col];
        int[][] atlantic = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < row; i++) {
            queue.add(new int[]{i,0});
        }

        for(int j = 0; j < col; j++) {
            queue.add(new int[]{0,j});
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int height = matrix[cur[0]][cur[1]];
            pacific[cur[0]][cur[1]] = 1;

            for(int i = 0; i < dx.length; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if(newX >= 0 && newX < row && newY >= 0 && newY < col && pacific[newX][newY] == 0 && matrix[newX][newY] >= height) {
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        for(int i = 0; i < row; i++) {
            queue.add(new int[]{i,col-1});
        }

        for(int j = 0; j < col; j++) {
            queue.add(new int[]{row-1,j});
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int height = matrix[cur[0]][cur[1]];
            atlantic[cur[0]][cur[1]] = 1;

            for(int i = 0; i < dx.length; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if(newX >= 0 && newX < row && newY >= 0 && newY < col && atlantic[newX][newY] == 0 && matrix[newX][newY] >= height) {
                    queue.add(new int[]{newX, newY});
                }
            }
        }


        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < row; i++) {
            for(int j=0; j < col; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    result.add(item);
                }
            }
        }

        return result;
    }
}
