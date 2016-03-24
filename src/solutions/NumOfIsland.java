package solutions;

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
}
