package solutions;

import util.TreeNode;

public class MaximumPathSum {
	
	int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper( root );
        return max;
    }
    
    public int helper(TreeNode root ){
        if( root == null ){
            return Integer.MIN_VALUE;
        }
        
        int left = Math.max(0, helper( root.left ));
        int right = Math.max(0, helper( root.right));
        max = Math.max(max, root.val + left + right );
        return root.val + Math.max(left, right);
    }
}
