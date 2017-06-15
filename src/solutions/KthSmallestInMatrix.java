package solutions;

import java.util.PriorityQueue;

public class KthSmallestInMatrix {
	public int kthSmallest(int[][] matrix, int k) { 
        int n = matrix.length;
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) q.offer(new Tuple(0,j,matrix[0][j]));
        
        for(int i = 0; i < k - 1; i++) {
            Tuple t = q.poll();
            if( t.x == n - 1 ) continue;
            q.offer(new Tuple(t.x+1,t.y, matrix[t.x+1][t.y]));
        }
        
        return q.poll().val;
    }
    
    class Tuple implements Comparable<Tuple> {
        int x,y,val;
        
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}
