package solutions;

import java.util.PriorityQueue;

public class FindKthLargest {
	public int findKthLargest(int[] nums, int k) {
        if( nums == null || nums.length == 0 || k < 1 )
        {
            return 0;
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k+1);
        
        for( int i : nums )
        {
            if( q.size() < k )
            {
                q.offer(i);
            }
            else
            {
                q.offer(i);
                q.poll();
            }
        }
        
        return q.poll();
    }
}
