package solutions;

/**
 * 962 Maximum Width Ramp
 */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int[] max = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            max[i] = i == nums.length - 1 ? nums[nums.length -1] : Math.max(nums[i], max[i+1]);
        }

        int left = 0;
        int right = 0;
        int res = 0;

        while(right < nums.length) {
            while(left < right && nums[left] > max[right]) {
                left++;
            }

            res = Math.max(res, right - left);
            right++;
        }

        return res;
    }
}
