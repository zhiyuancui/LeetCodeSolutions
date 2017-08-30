package solutions;

import util.TreeNode;

public class EqualTreePartition {
	TreeNode head;
    boolean equal = false;
    
    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null) return false;
        int total = getTotal(root);
        if (total % 2 != 0)   return false;
        
        head = root;
        checkEqual(root, total / 2 );
        return equal;
    }
    
    private int getTotal(TreeNode root) {
        if (root == null) return 0;
        return getTotal(root.left) + getTotal(root.right) + root.val;
    }
    
    private int checkEqual(TreeNode root, int target) {
        if (root == null || equal) return 0;
        
        int left = checkEqual(root.left, target);
        int right = checkEqual(root.right, target);
        
        if( root != head && root.val + left + right == target ) {
            equal = true;
            return 0;
        }
        
        return root.val + left + right;
    }
}
