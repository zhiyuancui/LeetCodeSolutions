package solutions;

import util.TreeNode;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
        if( root == null )
        {
            return false;
        }
        
        int val = sum - root.val;
        
        if( root.left == null && root.right == null )
        {
            return val == 0;
        }
        
        return hasPathSum( root.left, val ) || hasPathSum( root.right, val);
    }
}
