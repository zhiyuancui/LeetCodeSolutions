package solutions;

public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
        if( grid == null || grid.length == 0 ) {
            return 0;
        }
        int row = grid.length, n = grid[0].length;
        int result = 0, rowhits, colhits[n];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (!j || grid[i][j-1] == 'W') {
                    rowhits = 0;
                    for (int k=j; k<n && grid[i][k] != 'W'; k++)
                        rowhits += grid[i][k] == 'E';
                }
                if (!i || grid[i-1][j] == 'W') {
                    colhits[j] = 0;
                    for (int k=i; k<m && grid[k][j] != 'W'; k++)
                        colhits[j] += grid[k][j] == 'E';
                }
                if (grid[i][j] == '0')
                    result = max(result, rowhits + colhits[j]);
            }
        }
        return result;
    }
}
