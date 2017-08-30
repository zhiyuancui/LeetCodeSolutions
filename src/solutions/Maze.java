package solutions;

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
        int m=maze.length, n=maze[0].length;
        int[][] length=new int[m][n]; // record length
        for (int i=0;i<m*n;i++) length[i/n][i%n]=Integer.MAX_VALUE;
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        
        PriorityQueue<Point> list=new PriorityQueue<>((o1,o2)->o1.l-o2.l); // using priority queue
        
        list.offer(new Point(start[0], start[1], 0));
        
        while (!list.isEmpty()) {
            Point p=list.poll();
            if (length[p.x][p.y]<=p.l) continue; // if we have already found a route shorter
            length[p.x][p.y]=p.l;
            for (int i=0;i<4;i++) {
                int xx=p.x, yy=p.y, l=p.l;
                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0) {
                    xx+=dir[i][0];
                    yy+=dir[i][1];
                    l++;
                }
                xx-=dir[i][0];
                yy-=dir[i][1];
                l--;
                list.offer(new Point(xx, yy, l));
            }
        }
        return length[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:length[destination[0]][destination[1]];
    }
}
