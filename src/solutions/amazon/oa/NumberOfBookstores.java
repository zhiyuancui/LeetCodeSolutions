package solutions.amazon.oa;

/**
 * count number of amazon bookstores,
 * number of islands的变种
 */
public class NumberOfBookstores {
    int[] dx = {0,0,1,-1};
    int[] dy = {-1,1,0,0};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;


        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j =0; j<col; j++) {
                if(grid[i][j] == '1') {
                    findIsland(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }


    private void findIsland(int x, int y, char[][]grid) {
        if(x < 0 || y < 0 ||x>=grid.length || y>=grid[0].length||grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        for(int i =0; i < dx.length; i++){
            int newX = x +dx[i];
            int newY = y + dy[i];
            findIsland(newX,newY, grid);
        }
    }
}
