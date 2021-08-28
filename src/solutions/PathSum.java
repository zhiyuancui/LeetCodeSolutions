package solutions;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

public class PathSum {
    /**
     * Path Sum
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null ) {
            return false;
        }
        
        sum -= root.val;
        
        if( root.left == null && root.right == null ) {
            return sum == 0;
        }
        
        
        return hasPathSum( root.left, sum) || hasPathSum( root.right, sum);
        
    }
    
    
    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();
    /**
     * Path Sum IV
     * @param nums
     * @return
     */
    public int pathSum4(int[] nums) {
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
