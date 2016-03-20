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
        
        return check( left.left, right.left) && check( left.right, right.right);
        
    }
    
    public static void main(String[] args)
    {
    	
    	IsSymmetric s = new IsSymmetric();
    	TreeNode root = new TreeNode(0);
    	root.left = new TreeNode(1);
    	root.left.left = new TreeNode(2);
    	s.isSymmetric(root);
    }
}
