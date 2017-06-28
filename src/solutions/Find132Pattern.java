package solutions;

public class Find132Pattern {

	/**
	 * Reference to: https://discuss.leetcode.com/topic/68242/java-solutions-from-o-n-3-to-o-n-for-132-pattern
	 * @param nums
	 * @return
	 */
	public boolean find132pattern(int[] nums) {
        for (int j = 0, min = Integer.MAX_VALUE; j < nums.length; j++) {
             min = Math.min(nums[j], min);
             if (min == nums[j]) continue;
             
             for (int k = nums.length - 1; k > j; k--) {
                 if (min < nums[k] && nums[k] < nums[j]) return true;
             }
         }
         
         return false;
    }
}
