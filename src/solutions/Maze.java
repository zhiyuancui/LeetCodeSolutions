package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

	class Point{
        int x,y;
        public Point(int _x, int _y) {
            x = _x;
            y = _y;
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
}
