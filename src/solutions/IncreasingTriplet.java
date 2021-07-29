package solutions;

/**
 * 334 Increasing Triplet Subsequence
 */
public class IncreasingTriplet {

	public boolean increasingTriplet(int[] nums) {
		if( nums == null || nums.length < 3 ){
            return false;
        }
        
        Integer middle = null, lower = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (middle != null && nums[i] > middle) {
                return true;
            }
            if (nums[i] <= lower)
                lower = nums[i];
            else
                middle = (middle == null || nums[i] < middle) ? nums[i] : middle;
        }

        return false;
    }
}
