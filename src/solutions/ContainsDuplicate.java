package solutions;

import java.util.*;

public class ContainsDuplicate {

	/**
	 * Given an array of integers, 
	 * find if the array contains any duplicates. 
	 * Your function should return true 
	 * if any value appears at least twice in the array, 
	 * and it should return false if every element is distinct.
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
        
		HashSet<Integer> set = new HashSet<Integer>();
		
		for( int i : nums )
		{
			if( set.contains(i) )
			{
				return true;
			}
			else
			{
				set.add(i);
			}
		}
		return false;
    }
	

	/**
	 * Contains Duplicate III
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
	        TreeSet<Long> set = new TreeSet<>();
	        set.add((long) nums[0]);
	        for (int i = 1; i < nums.length; i++) {
		        if (i > k) set.remove((long) nums[i - k - 1]);
		        long left = (long) nums[i] - t;
		        long right = (long) nums[i] + t;
		        if (left <= right && !set.subSet(left, right + 1).isEmpty()) return true;
		        set.add((long) nums[i]);
	        }
        return false;
    }
}
