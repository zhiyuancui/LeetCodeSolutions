package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTrees {
	int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    class Node {
        int x;
        int y;
        int val;
        
        public Node(int _x, int _y, int v) {
            x = _x;
            y = _y;
            val = v;
        }
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
        if( forest == null || forest.size() == 0 ) return 0;
        int row = forest.size(), col = forest.get(0).size();
        
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(int i =0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if( forest.get(i).get(j) > 1 ) {
                    q.add( new Node(i,j, forest.get(i).get(j) ) );
                }
            }
        }
        
        Node start = new Node(0,0,0);
        int sum = 0;
        while( !q.isEmpty() ) {
            Node tree = q.poll();
            int step = minStep(forest, start, tree, row, col);
            if( step < 0 ) {
                return -1;
            }
            
            sum += step;
            start.x = tree.x;
            start.y = tree.y;
        }
        
        return sum;
    }
    
    private int minStep(List<List<Integer>> forest, Node start, Node tree, int row,int col) {
        int step = 0;
        boolean[][] visited = new boolean[row][col];
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        
        while( !queue.isEmpty() ) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if( cur.x == tree.x && cur.y == tree.y ) {
                    return step;
                }
                
                for(int j = 0; j < dx.length; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if( nx >= 0 && nx < row && ny >= 0 && ny < col && forest.get(nx).get(ny) != 0 && !visited[nx][ny] ) {
                        queue.add(new Node(nx,ny,0));
                        visited[nx][ny] = true;
                    }
                }
            }
            step++;
        }
        
        return -1;
    }
}
