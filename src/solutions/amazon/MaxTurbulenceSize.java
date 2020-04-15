package solutions.amazon;

public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] nums) {
        int len = nums.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < len; ++i) {
            int c = Integer.compare(nums[i-1], nums[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == len-1 || c * Integer.compare(nums[i], nums[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;

    }
}
