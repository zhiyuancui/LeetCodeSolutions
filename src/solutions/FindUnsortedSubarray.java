package solutions;

import java.util.Arrays;

public class FindUnsortedSubarray {
	
	/**
	 * brute force solution
	 * Reference to : http://www.cnblogs.com/grandyang/p/6876457.html
	 * @param nums
	 * @return
	 */
	public int findUnsortedSubarray2(int[] nums) {
		int len = nums.length;
		int[] clone = new int[len];
		for(int i = 0; i < nums.length; i++) {
			clone[i] = nums[i];
		}
		
		Arrays.sort( clone );
		
		int start = 0;
		int end = nums.length - 1;
		
		for(; start < nums.length; start++) {
			if( clone[start] != nums[start] ) {
                break;
			}
		}
		
		for(; end > start; end--) {
			if( clone[end] != nums[end] ) {
                break;
			}
		}
		
		return end - start + 1;
	}
	
	
	public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i=1;i<n;i++) {
          max = Math.max(max, nums[i]);
          min = Math.min(min, nums[n-1-i]);
          if (nums[i] < max) end = i;
          if (nums[n-1-i] > min) beg = n-1-i; 
        }
        return end - beg + 1;
    }
	
	
}
