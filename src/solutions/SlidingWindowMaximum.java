package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if( nums == null || nums.length < k || k == 0 ){
            return new int[0];
        }
        
        int[] result = new int[ nums.length - k + 1];
        
        Deque<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            while( !q.isEmpty() && nums[i] > nums[q.getLast()]){
                q.removeLast();
            }
            q.add(i);
            
            if( i - q.getFirst() + 1 > k ){
                q.removeFirst();
            }
            
            if( i >= k - 1 ){
                result[ i - k + 1 ] = nums[q.getFirst()];
            }
        }
        
        return result;
    }
}
