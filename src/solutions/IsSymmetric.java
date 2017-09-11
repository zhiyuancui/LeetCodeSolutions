package solutions;

import util.TreeNode;

public class IsSymmetric {

	public boolean isSymmetric(TreeNode root) {
        if( root == null ){
            return true;
        }
        
        return check( root.left, root.right);
    }
    
    public boolean check(TreeNode left, TreeNode right){
        
        if( left == null && right == null ){
            return true;
        }
        
        if( left == null || right == null ){
            return false;
        }
        
        if( left.val != right.val ){
            return false;
        }
        
        return check( left.right, right.left) && check( left.left, right.right);
        
    }
}
