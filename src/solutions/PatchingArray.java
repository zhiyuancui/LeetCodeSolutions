package solutions;

public class PatchingArray {
	public int minPatches(int[] nums, int n) {
        if (n <= 0) return 0;
        nums = nums == null ? new int[0] : nums;
        int current_ind = 0, ret = 0;
        long boundary_val = 1, sum = 0;
        while (boundary_val <= n) {
            if (current_ind < nums.length && nums[current_ind] <= boundary_val) {
                sum += nums[current_ind++];
                boundary_val = sum + 1;
            } else {
                ret++;
                sum += boundary_val;
                boundary_val = sum + 1;
            }
        }
        return ret;
    }
}
