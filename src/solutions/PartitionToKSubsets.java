package solutions;

import java.util.Arrays;

/**
 * 698 Partition to K Equal Sum Subsets
 */
public class PartitionToKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        if(k == 1) {
            return true;
        }

        int sum = 0;
        for(int i : nums) {
            sum += i;
        }

        if(sum % k != 0) {
            return false;
        }

        int target = sum / k;

        Arrays.sort(nums);
        if(nums[nums.length - 1] > target) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, k, target, visited,0,0);
    }

    private boolean dfs(int[] nums, int k, int target, boolean[] visited, int pos, int sum) {
        if(k == 1) {
            return true;
        }

        if(sum == target) {
            return dfs(nums, k - 1, target, visited, 0,0);
        }

        for(int i = pos; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
                continue;
            }

            if(!visited[i] && nums[i] + sum <= target) {
                visited[i] = true;
                if(dfs(nums, k, target, visited, i+1,sum+nums[i])) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
}
