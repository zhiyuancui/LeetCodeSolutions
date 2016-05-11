package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfIsland {
	private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};
    public int numIslands(char[][] grid) {
        if( grid == null || grid.length == 0 || grid[0].length == 0 ){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
    
        int number = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if( grid[i][j] == '1' )
                {
                    findIsland(grid, row, col, i,j);
                    number++;
                }
            }
        }
        
        return number;
    }
    
    
    private void findIsland(char[][] grid, int row, int col, int x, int y ){
        grid[x][y] = '0';
        for(int i = 0; i < dx.length; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if( newX >= 0 && newX < row && newY >= 0 && newY < col){
                if( grid[newX][newY] == '1'){
                    findIsland(grid, row, col,newX, newY);
                }
            }
        }
    }
    
    /**
     * Number of Islands II
     * 
     * A 2d grid map of m rows and n columns is initially filled with water. 
     * We may perform an addLand operation which turns the water at position (row, col) into a land. 
     * Given a list of positions to operate, count the number of islands after each addLand operation. 
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
     * You may assume all four edges of the grid are all surrounded by water.
     * 
     * Reference to https://leetcode.com/discuss/69572/easiest-java-solution-with-explanations
     * 
     */
    public List<Integer> numIslands2(int row, int col, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        
        if( row <= 0 || col <= 0 ){
        	return result;
        }
        
        int count = 0;
        int[] roots = new int[ row * col ];
        Arrays.fill(roots, -1);
        
        for(int[] p : positions ){
        	int root = col * p[0] + p[1];
        	roots[ root ] = root;
        	count++;
        	
        	for(int i = 0; i < dx.length; i++ ){
        		int x = p[0] + dx[i];
        		int y = p[1] + dy[i];
        		
        		int neighbor = col * x + y;
        		if( x < 0 || x >= row || y >= col || y < 0 || roots[neighbor] == -1 ){
        			continue;
        		}
        		
        		int rootNeighbor = findRoot( roots, neighbor );
        		if( root != rootNeighbor ){
        			roots[ root ] = rootNeighbor;
        			root = rootNeighbor;
        			count--;
        		}
        	}
        	
        	result.add( count );
        }
        
        return result;
    }
    
    private int findRoot(int[] roots, int id){
    	while( id != roots[id] ){
    		id = roots[id];
    	}    	
    	return id;
    }
    
    public static void main(String[] args){
    	NumOfIsland n = new NumOfIsland();
    	int[][] positions = {{0,0},{0,1},{2,1},{1,1},{1,0}};
    	n.numIslands2(3, 3, positions);
    }
}
