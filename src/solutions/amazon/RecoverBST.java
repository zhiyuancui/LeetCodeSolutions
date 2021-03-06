package solutions.amazon;

import util.TreeNode;

public class RecoverBST {

	private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode last = null;
    
    public void recoverTree(TreeNode root) {
        
        if( root == null ) {
            return;
        }
        
        travel( root );
        
        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void travel( TreeNode root ) {
        if( root == null ) {
            return;
        }
        
        travel( root.left );
        if( last != null && first == null && root.val <= last.val ) {
            first = last;
        }
        if( first != null && root.val <= last.val ) {
            second = root;
        }
        
        last = root;
        travel( root.right);
    }
    
}
