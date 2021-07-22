package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 42 Trapping Rain Water
 */
public class TrappingRainWater {

	public int trap(int[] height) {
        
        if( height == null || height.length == 0 )
        {
            return 0;
        }
        
        //Find max
        int max = 0;
        for( int i = 1; i < height.length; i++ )
        {
            if(height[i] > height[max])
            {
                max = i;
            }
        }
        
        //from left to max
        int water = 0;
        int top = 0;
        for(int i = 0; i < max; i++)
        {
            if( height[i] > top )
            {
                top = height[i];
            }
            else
            {
                water += top - height[i];
            }
        }
        
        //from right to max
        top = 0;
        for(int i = height.length - 1; i > max; i--)
        {
            if( height[i] > top )
            {
                top = height[i];
            }
            else
            {
                water += top - height[i];
            }
        }
        
        return water;
    }
	
	/**
	 * Trapping Rain Water II
	 * @author zhiyuan.cui
	 *
	 */
	    public class Cell {
	        int row;
	        int col;
	        int height;
	        public Cell(int row, int col, int height) {
	            this.row = row;
	            this.col = col;
	            this.height = height;
	        }
	    }

	    public int trapRainWater(int[][] heights) {
	        if (heights == null || heights.length == 0 || heights[0].length == 0)
	            return 0;

	        PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>(){
	            public int compare(Cell a, Cell b) {
	                return a.height - b.height;
	            }
	        });
	        
	        int m = heights.length;
	        int n = heights[0].length;
	        boolean[][] visited = new boolean[m][n];

	        // Initially, add all the Cells which are on borders to the queue.
	        for (int i = 0; i < m; i++) {
	            visited[i][0] = true;
	            visited[i][n - 1] = true;
	            queue.offer(new Cell(i, 0, heights[i][0]));
	            queue.offer(new Cell(i, n - 1, heights[i][n - 1]));
	        }

	        for (int i = 0; i < n; i++) {
	            visited[0][i] = true;
	            visited[m - 1][i] = true;
	            queue.offer(new Cell(0, i, heights[0][i]));
	            queue.offer(new Cell(m - 1, i, heights[m - 1][i]));
	        }

	        // from the borders, pick the shortest cell visited and check its neighbors:
	        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
	       // add all its neighbors to the queue.
	        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	        int res = 0;
	        while (!queue.isEmpty()) {
	            Cell cell = queue.poll();
	            for (int[] dir : dirs) {
	                int row = cell.row + dir[0];
	                int col = cell.col + dir[1];
	                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
	                    visited[row][col] = true;
	                    res += Math.max(0, cell.height - heights[row][col]);
	                    queue.offer(new Cell(row, col, Math.max(heights[row][col], cell.height)));
	                }
	            }
	        }
	        
	        return res;
	    }
	
	
}
