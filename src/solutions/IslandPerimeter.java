package solutions;

public class IslandPerimeter {
	
	    private int[] dx = {0,0,1,-1};
	    private int[] dy = {1,-1,0,0};
	    
	    public int islandPerimeter(int[][] grid) {
	        
	        if( grid == null || grid.length == 0 ){
	            return 0;
	        }
	        
	        int row = grid.length;
	        int col = grid[0].length;
	        
	        int perimeter = 0;
	        
	        for(int i = 0; i < row; i++){
	            for(int j = 0; j < col; j++){
	                if( grid[i][j] == 1 ){
	                    perimeter += countEdge( grid,i,j );
	                }
	            }
	        }
	        
	        return perimeter;
	    }
	    
	    private int countEdge(int[][] grid, int x, int y){
	        
	        int row = grid.length;
	        int col = grid[0].length;
	        int edges = 0;
	        
	        for(int i = 0; i < dx.length; i++){
	            int newX = x + dx[i];
	            int newY = y + dy[i];
	            
	            if(newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] == 0 ){
	                edges++;
	            }
	        }
	        
	        return edges;
	    }	
}
