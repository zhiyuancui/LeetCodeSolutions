package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 666 Path Sum IV
 */
public class PathSumIV {
    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();

    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }

        traverse(nums[0] / 10, 0);

        return sum;
    }

    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;

        int curSum = preSum + tree.get(root);

        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }

        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }
}
