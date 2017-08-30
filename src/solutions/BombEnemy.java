package solutions;

public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if( grid == null || grid.length == 0 ) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        
        int rowCount = 0;
        int result = 0;
        
        int[] colCount = new int[col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if( j == 0 || grid[i][j-1] =='W' ) {
                    rowCount = 0;
                    for(int k = j; k < col && grid[i][k] != 'W'; k++) {
                        if( grid[i][k] == 'E' ) {
                            rowCount++;
                        }
                    }
                } 
                if( i == 0 || grid[i-1][j] == 'W' ) {
                    colCount[j] = 0;
                    for(int k = i; k < row && grid[k][j] != 'W'; k++) {
                        if( grid[k][j] == 'E' ) {
                            colCount[j]++;
                        }
                    }
                }
                
                if( grid[i][j] == '0' ) {
                    result = Math.max(result, rowCount + colCount[j] );
                }
            }
        }
        
        return result;
    }
}
