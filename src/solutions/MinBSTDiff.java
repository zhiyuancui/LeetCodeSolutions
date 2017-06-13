package solutions;

import util.TreeNode;

public class MinBSTDiff {
	int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if( root == null ) return min;
        
        getMinimumDifference(root.left);
        if( prev != null ){
            min = Math.min(min, Math.abs(root.val - prev));
        }
        
        prev = root.val;
        getMinimumDifference(root.right);
        
        return min;
    }
}
