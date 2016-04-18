package solutions;

public class PatchingArray {
	public int minPatches(int[] nums, int n) {
        if (n <= 0) return 0;
        nums = nums == null ? new int[0] : nums;
        int cur = 0, result = 0;
        long boundary_val = 1, sum = 0;
        while (boundary_val <= n) {
            if (cur < nums.length && nums[cur] <= boundary_val) {
                sum += nums[cur++];
                boundary_val = sum + 1;
            } else {
                result++;
                sum += boundary_val;
                boundary_val = sum + 1;
            }
        }
        return result;
    }
	
	public static void main(String[] args){
		PatchingArray p = new PatchingArray();
		int[] nums = {1,5,10};
		p.minPatches(nums, 20);
	}
}
