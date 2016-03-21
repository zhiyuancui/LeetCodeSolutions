package solutions;

public class IncreasingTriplet {

	public boolean increasingTriplet(int[] nums) {
		if( nums == null || nums.length < 3 ){
            return false;
        }
        
        Integer upper = null, lower = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (upper != null && nums[i] > upper) {
                return true;
            }
            if (nums[i] <= lower)
                lower = nums[i];
            else
                upper = (upper == null || nums[i] < upper) ? nums[i] : upper;
        }

        return false;
    }
}
