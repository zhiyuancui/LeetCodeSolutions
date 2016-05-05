package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {

	/**
	 * 
	 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
	 * Each 0 marks an empty land which you can pass by freely.
	 * Each 1 marks a building which you cannot pass through.
	 * Each 2 marks an obstacle which you cannot pass through.
	 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
	 * 
	 * 1 - 0 - 2 - 0 - 1
	 * |   |   |   |   |
	 * 0 - 0 - 0 - 0 - 0
	 * |   |   |   |   |
	 * 0 - 0 - 1 - 0 - 0
	 * 
	 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
	 * 
	 * 
	 * Reference to : https://leetcode.com/discuss/74999/java-solution-with-explanation-and-time-complexity-analysis
	 * @param grid
	 * @return
	 */
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
                                        //The shortest distance from [nextRow][nextCol] to thic building
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
