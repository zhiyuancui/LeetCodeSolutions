package solutions;

import util.TreeNode;

public class MinDepth {

	public int minDepth(TreeNode root) {
        if( root == null )
        {
            return 0;
        }
        
        return getHeight( root );
    }
    
    private int getHeight(TreeNode root )
    {
        if( root == null )
        {
            return Integer.MAX_VALUE;
        }
        
        if( root.left == null && root.right == null )
        {
            return 1;
        }
        
        return Math.min(getHeight( root.left), getHeight( root.right)) + 1;
    }
}
