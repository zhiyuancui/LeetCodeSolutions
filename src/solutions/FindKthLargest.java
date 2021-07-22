package solutions;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215 Kth Largest Element in an Array
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
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

    /**
     * Quick Select
     */
    private Random random = new Random(System.currentTimeMillis());

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int target = len - k;

        while(true) {
            int index = partition(nums, left, right);
            if(index == target) {
                return nums[index];
            } else if(index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }


        int pivot = nums[left];

        int j = left;

        for(int i = left + 1; i <= right; i++) {
            if(nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }

        swap(nums, j, left);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
