package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 317 Shortest Distance from All Buildings
 */
public class ShortestDistance {

	public int shortestDistance(int[][] grid) {
        if( grid == null || grid[0].length == 0 ){
            return 0;
        }
        
        final int[] dx = new int[] {0,1,0,-1};
        final int[] dy = new int[] {1,0,-1,0};
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] distance = new int[ row ][ col ];
        
        int[][] reach = new int[ row ][ col ];
        
        int buildingNum = 0;
        
        for(int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                if( grid[i][j] == 1 ){
                    buildingNum++;
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.offer(new int[]{i,j});
                    
                    boolean[][] isVisited = new boolean[ row ][ col ];
                    int level = 1;
                    
                    while( !q.isEmpty() ){
                        int size = q.size();
                        for(int m = 0; m < size; m++){
                            int[] cur = q.poll();
                            
                            for(int k = 0; k < dx.length; k++ ){
                                int nextRow = cur[0] + dx[k];
                                int nextCol = cur[1] + dy[k];
                                
                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                                    && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                                        //The shortest distance from [nextRow][nextCol] to this building
                                        // is 'level'.
                                        distance[nextRow][nextCol] += level;
                                        reach[nextRow][nextCol]++;

                                        isVisited[nextRow][nextCol] = true;
                                        q.offer(new int[] {nextRow, nextCol});
                                    }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}
