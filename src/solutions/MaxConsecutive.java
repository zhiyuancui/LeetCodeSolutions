package solutions;

public class MaxConsecutive {

	public int findMaxConsecutiveOnes(int[] nums) {
        
        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] == 1 ){
                count++;
                max = Math.max(max, count);
            } else {
                count=0;
            }
         
        }
        
        return max;
    }
	
	/**
	 * Max Consecutive Ones II
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        for (int left = 0, high = 0; high < nums.length; high++) {
            if (nums[high] == 0)   {                                        
                zero++;
            }
            while (zero > k) {
                if (nums[left] == 0) {   
                		zero--;        
                }
                left++;
            }
            max = Math.max(max, high - left + 1);
        }                                                               
        return max;        
    }
}
