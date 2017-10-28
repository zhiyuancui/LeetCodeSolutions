package solutions;

import java.util.Arrays;

public class DungeonGame {
	/**
	 * dp[i][j] 
	 * @param dungeon
	 * @return
	 */
	public int calculateMinimumHP(int[][] dungeon) {
        if( dungeon == null || dungeon.length == 0 || dungeon[0].length == 0 ){
            return 0;
        }
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        int[][] matrix = new int[ row ][ col ];
        
        matrix[ row - 1 ][ col - 1 ] = Math.max(1, 1-dungeon[row - 1 ][ col - 1 ]);
        
        for(int i = row - 2; i >= 0; i--){
            matrix[i][ col - 1 ] = Math.max(1, matrix[i+1][col-1] - dungeon[i][col - 1 ]);
            printMatrix(matrix);
        }
        
        for(int i = col -2; i >= 0; i--){
            matrix[ row - 1 ][ i ] = Math.max(1, matrix[ row - 1 ][ i + 1 ] - dungeon[ row - 1 ][ i ]);
            printMatrix(matrix);
        }
        
        for(int i = row - 2; i >= 0; i--){
            for(int j = col - 2; j >= 0 ; j-- ){
                int hp = Math.min( matrix[i+1][j], matrix[i][j+1]) - dungeon[i][j];
                matrix[i][j] = Math.max(hp, 1);
            }
        }
        
        return matrix[0][0];
    }
	
	/**
	 * Use Rolling arrays
	 * @param dungeon
	 * @return
	 */
	public int calculateMinimumHP2(int[][] dungeon) {
        if( dungeon == null || dungeon.length == 0 || dungeon[0].length == 0 ){
            return 0;
        }
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        int[] dp = new int[ col + 1 ];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[ col - 1 ] = 1;
        for(int i = row - 1; i >= 0; i--){
            for(int j = col-1;j >= 0; j--){
                int hp = Math.min(dp[j],dp[j+1]) - dungeon[i][j];
                dp[j] = Math.max(1,hp);
            }
        }
        
        return dp[0];
    }
	
	private void printMatrix(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print( matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("/////////////////////////////");
	}
	
	public static void main(String[] args){
		DungeonGame d = new DungeonGame();
		int[][] dungeon = new int[3][3];
		dungeon[0][0] = -2;
		dungeon[0][1] = -3;
		dungeon[0][2] = 3;
		dungeon[1][0] = -5;
		dungeon[1][1] = -10;
		dungeon[1][2] = 1;
		dungeon[2][0] = 10;
		dungeon[2][1] = 30;
		dungeon[2][2] = -5;
		d.calculateMinimumHP(dungeon);
	}
}
