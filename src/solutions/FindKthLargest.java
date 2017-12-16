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
        	q.offer(i);
            if( q.size() > k ){
                q.poll();
            }
        }
        
        return q.poll();
    }
	
	public int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int pivot = partition(nums, lo, hi);
            if(pivot < k) {
                lo = pivot + 1;
            } else if ( pivot > k) {
                hi = pivot - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
        		i++;
            while(i < hi && nums[i] < nums[lo] ){
                i++;
            }
            j--;
            while(j > lo && nums[lo] < nums[j] ){
                j--;
            }
            if( i >= j ) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        final int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
