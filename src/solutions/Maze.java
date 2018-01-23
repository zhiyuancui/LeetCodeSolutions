package solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Maze {

	class Point{
        int x,y,l;
        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
        
        public Point(int _x, int _y, int _l) {
        		x = _x;
        		y = _y;
        		l =_l;
        }
    }
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    /**
     *  The Maze 
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if( maze == null || maze.length == 0 ) {
            return false;
        }
        
        if (start[0]==destination[0] && start[1]==destination[1]) {
            return true;
        }
        
        int row=maze.length, col=maze[0].length;
        
        boolean[][] visited=new boolean[row][col];
        
        Queue<Point> queue=new LinkedList<>();
        
        visited[start[0]][start[1]]=true;
        queue.offer(new Point(start[0], start[1]));
        
        while (!queue.isEmpty()) {
            Point cur=queue.poll();
            for (int i=0;i<dx.length; i++) {
                int newx = cur.x;
                int newy = cur.y;
                while( newx >= 0 && newx < row && newy >= 0 && newy < col && maze[newx][newy] == 0 ){
                    newx += dx[i];
                    newy += dy[i];
                }
                newx -= dx[i];
                newy -= dy[i];
                if (visited[newx][newy]) continue;
                visited[newx][newy]=true;
                if (newx==destination[0] && newy==destination[1]) return true;
                queue.offer(new Point(newx,newy));
            }
        }
        return false;
    }
    
   /**
    * Maze II
    * @param maze
    * @param start
    * @param destination
    * @return
    */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    	if( maze == null || maze.length == 0 ) {
            return 0;
        }
        
        int row = maze.length;
        int col = maze[0].length;
        int[][] dp = new int[ row ][ col ];
        for( int[] r : dp ){
            for( int i : r ) {
                i = 1;
            }
        }
        /*(for( int i = 0; i < row; i++){
            for( int j = 0; j < col; j++ ) {
               dp[i][j] = Integer.MAX_VALUE;
            }
        }*/
        
        for( int[] r : dp ){
            for( int i : r ) {
                System.out.print(i+",");
            }
            System.out.println();
        }
        
        
        PriorityQueue<Point> q = new PriorityQueue<>( (a,b)->a.l - b.l );
        q.offer( new Point(start[0], start[1], 0) );
        
        while( !q.isEmpty() ) {
            Point cur = q.poll();
            if( dp[cur.x][cur.y] <= cur.l ) {
                continue;
            }
            
            dp[ cur.x ][cur.y ] = cur.l;
            for( int i = 0; i < dx.length; i++ ) {
                int nx = cur.x;
                int ny = cur.y;
                int len = cur.l;
                while( nx >= 0 && nx < row && ny >= 0 && ny < col && maze[nx][ny] == 0 ) {
                    nx += dx[i];
                    ny += dy[i];
                    len++;
                }
                
                nx -= dx[i];
                ny -= dy[i];
                len--;
                q.offer( new Point(nx, ny, len));
            }
        }
        
        for( int[] r : dp ){
            for( int i : r ) {
                System.out.print(i+",");
            }
            System.out.println();
        }
        
        return dp[ destination[0] ][ destination[1] ] == Integer.MAX_VALUE ? -1 : dp[ destination[0] ][ destination[1] ];
    }
}
