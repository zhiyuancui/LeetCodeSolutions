package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIsland {
	private int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public int numDistinctIslands(int[][] grid) {
        if( grid == null || grid.length == 0 ) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        
        Set<List<List<Integer>>> islands = new HashSet<>();
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if( grid[i][j] == 1 ){
                    List<List<Integer>> island = new ArrayList<>();
                    if( dfs(i,j,i,j, grid, row, col, island) ) {
                        islands.add( island );
                    }
                }
            }
        }
        
        return islands.size();
    }

    private boolean dfs(int x0, int y0, int x, int y, int[][] grid, int row, int col, List<List<Integer>> island) {
        if( x < 0 || y < 0 || x >= row || y >= col || grid[x][y] != 1 ) {
            return false;
        }
        
        island.add( Arrays.asList(x-x0,y-y0) );
        grid[x][y] = -1;
        for(int i =0; i < d.length; i++) {
            dfs(x0,y0, x + d[i][0], y + d[i][1], grid, row, col, island);
        }
        return true;
    }
}
