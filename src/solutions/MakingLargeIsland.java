package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 827 Making A Large Island
 */
public class MakingLargeIsland {
    Map<Integer,Integer> selfCountMap = new HashMap<>();
    Map<Integer, Integer> neighborCountMap = new HashMap<>();

    public int largestIsland(int[][] grid) {
        if( grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int max = 1;
        int islandSize = 2;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, islandSize);
                    islandSize++;
                }
            }
        }

        for(int key: selfCountMap.keySet()) {
            max = Math.max(max, selfCountMap.get(key) + neighborCountMap.getOrDefault(key,0));
        }

        return max;
    }

    private void dfs(int[][] grid, int x, int y, int islandSize) {
        int row = grid.length;
        int col = grid[0].length;

        if(x < 0 || y < 0 || x >= row || y >= col) {
            return;
        }

        if(grid[x][y] == 0) {
            int neighborCount = 1;
            Set<Integer> visited = new HashSet<>();

            neighborCount += getNeighbor(grid, x+1, y, islandSize, visited);
            neighborCount += getNeighbor(grid, x-1, y, islandSize, visited);
            neighborCount += getNeighbor(grid, x, y+1, islandSize, visited);
            neighborCount += getNeighbor(grid, x, y-1, islandSize, visited);

            int max = Math.max(neighborCount, neighborCountMap.getOrDefault(islandSize, 0));
            neighborCountMap.put(islandSize, max);
            return;
        } else if(grid[x][y] != 1) {
            return;
        }

        grid[x][y] = islandSize;
        selfCountMap.put(islandSize, selfCountMap.getOrDefault(islandSize,0)+1);

        dfs(grid,x,y-1, islandSize);
        dfs(grid,x,y+1, islandSize);
        dfs(grid,x+1,y, islandSize);
        dfs(grid,x-1,y, islandSize);
    }

    private int getNeighbor(int[][] grid, int x, int y, int islandSize, Set<Integer> visited) {
        int row = grid.length;
        int col = grid[0].length;

        if(x < 0 || y < 0 || x >= row || y >= col) {
            return 0;
        }

        if(grid[x][y] > 1 && grid[x][y] != islandSize && !visited.contains(grid[x][y])) {
            visited.add(grid[x][y]);
            return selfCountMap.get(grid[x][y]);
        }

        return 0;
    }
}
