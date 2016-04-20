package solutions;

import util.TreeNode;

public class IsValidBST {
	private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    
    public boolean isValidBST(TreeNode root) {
        if( root == null ){
            return true;
        }    
        
        if( !isValidBST( root.left ) ){
            return false;
        }
        
        //skip if the root val is min value of integer.
        if( !firstNode && lastVal >= root.val ){
            return false;
        }
        
        firstNode = false;
        lastVal = root.val;
        if( !isValidBST( root.right ) ){
            return false;
        }
        
        return true;
    }
	
}
