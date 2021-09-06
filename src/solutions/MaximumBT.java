package solutions;

import util.TreeNode;

/**
 * 654 Maximum Binary Tree
 */
public class MaximumBT {
   public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        
        int idxMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idxMax]) {
                idxMax = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idxMax]);
        
        root.left = build(nums, start, idxMax - 1);
        root.right = build(nums, idxMax + 1, end);
        
        return root;
    }
}
