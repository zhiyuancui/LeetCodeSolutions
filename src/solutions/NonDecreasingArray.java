package solutions;

public class NonDecreasingArray {
	 public boolean checkPossibility(int[] nums) {
	        int n = nums.length, count = 0;
	        
	        for (int i = 0; i + 1 < n; i++) {
	            if (nums[i] > nums[i + 1]) {
	                count++;
	                if (i > 0 && nums[i + 1] < nums[i - 1]) {
	                    nums[i + 1] = nums[i];
	                }
	            }
	        }
	            
	        return count <= 1;
	    }
}
