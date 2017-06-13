package solutions;

import util.TreeNode;

public class BinaryTreeTilt {

	int sum;
    public int findTilt(TreeNode root) {
        if( root == null ) {
            return 0;
        }
        postOrder(root);
        return sum;
    }
    
    private int postOrder(TreeNode root ){
        if( root == null ){
            return 0;
        }
        
        int left = postOrder(root.left);
        int right = postOrder( root.right);
        sum += Math.abs( left - right );
        return left + right + root.val;
    }
}
