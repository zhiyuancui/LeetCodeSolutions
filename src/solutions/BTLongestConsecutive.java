package solutions;

import util.TreeNode;

/**
 * 298 Binary Tree Longest Consecutive Sequence
 */
public class BTLongestConsecutive {
	   private int max = 0;
	    public int longestConsecutive(TreeNode root) {
	        if(root == null) return 0;
	        helper(root, 0, root.val);
	        return max;
	    }
	    
	    public void helper(TreeNode root, int cur, int target){
	        if(root == null) return;
	        if(root.val == target) cur++;
	        else cur = 1;
	        max = Math.max(cur, max);
	        helper(root.left, cur, root.val + 1);
	        helper(root.right, cur, root.val + 1);
	    }
}
