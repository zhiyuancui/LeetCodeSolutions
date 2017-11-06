package solutions;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF 
 * as you may assume that the distance to a gate is less than 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * 
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * 
 * 
 * After running your function, the 2D grid should be:
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 * 
 * Reference to : https://leetcode.com/discuss/78333/my-short-java-solution-very-easy-to-understand
 * 
 * @author Zhiyuan
 *
 */
public class WallsGates {
	int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    public void wallsAndGates(int[][] rooms) {
        if( rooms == null || rooms.length == 0 ) {
            return;
        }
        
        int row = rooms.length;
        int col = rooms[0].length;
        
        for(int i = 0; i < row; i++ ) {
            for(int j = 0; j < col; j++ ) {
                if( rooms[i][j] == 0 ) {
                    update(rooms, i, j, row, col,0);
                }
            }
        }
        
    }
    
    private void update(int[][] rooms, int x, int y, int row, int col, int dist ) {
        rooms[x][y] = dist;
        
        for(int i = 0; i < dx.length; i++ ) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( nx >= 0 && ny >= 0 && nx < row && ny < col && rooms[nx][ny] > 0 && rooms[nx][ny] > dist ) {
                update( rooms, nx, ny, row, col, dist + 1 );
            }
        }
    }
}
