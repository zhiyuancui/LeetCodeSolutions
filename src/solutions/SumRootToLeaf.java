package solutions;

import util.TreeNode;

public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
        return travesal(root,0);
    }
    
    
    private int travesal(TreeNode root, int prev )
    {
        if( root == null )
        {
            return 0;
        }
        
        int sum = prev * 10 + root.val;
        
        if( root.left == null && root.right == null )
        {
            return sum;
        }
        
        return travesal(root.left, sum) + travesal( root.right, sum);
    }
}
