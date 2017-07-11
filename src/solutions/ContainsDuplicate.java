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
        if (nums == null || nums.length == 0) {
        	return false;
        }
	        TreeSet<Long> set = new TreeSet<>();
	        set.add((long) nums[0]);
	        for (int i = 1; i < nums.length; i++) {
		        if (i > k) set.remove((long) nums[i - k - 1]);
		        long left = (long) nums[i] - t;
		        long right = (long) nums[i] + t;
		        if (left <= right && !set.subSet(left, right + 1).isEmpty()) {
		        	return true;
		        }
		        set.add((long) nums[i]);
	        }
        return false;
    }
	
	/**
	 * O(N) solution
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
	
	/**
	 * Contains Duplicate II
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        if( nums.length < k ) {
            return false;
        }
        
        
        for(int i = 0; i < nums.length; i++){
            if( map.containsKey(nums[i]) ){
                int index = map.get(nums[i]);
                if( i - index <= k ) {
                    return true;
                } else {
                    map.put( nums[i],i);
                }
            } else{
                map.put( nums[i],i);
            }
            
        }
        
        return false;
    }
	
	
}
