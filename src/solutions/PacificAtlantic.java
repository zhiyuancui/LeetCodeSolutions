package solutions;

import java.util.LinkedList;
import java.util.List;

public class PacificAtlantic {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        boolean[][]pacific = new boolean[row][col];
        boolean[][]atlantic = new boolean[row][col];
        for(int i=0; i<row; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, col-1);
        }
        for(int i=0; i<col; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, row-1, i);
        }
        
        for (int i = 0; i < row; i++) 
            for (int j = 0; j < col; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(new int[] {i, j});
        return res;
    }
    
	int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
    		int row = matrix.length, col = matrix[0].length;
        if(x<0 || x>= row || y<0 || y>= col || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int i = 0; i < dx.length; i++ ){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(matrix,visited,matrix[x][y],nx,ny);
        }
    }
}
