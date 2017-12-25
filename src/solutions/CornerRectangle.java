package solutions;

public class CornerRectangle {
	public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i <row - 1; i++) {
            for (int j = i + 1; j < row; j++) {
                int counter = 0;
                for (int k = 0; k < col; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) counter++;
                }
                if (counter > 0) ans += counter * (counter - 1) / 2;
            }
        }
        return ans;
    }
}
