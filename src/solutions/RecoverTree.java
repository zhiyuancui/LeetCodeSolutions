package solutions;

import util.TreeNode;

public class RecoverTree {

	private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode last = new TreeNode( Integer.MIN_VALUE );
    
    public void recoverTree(TreeNode root) {
        
        if( root == null )
        {
            return;
        }
        
        travel( root );
        
        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void travel( TreeNode root )
    {
        if( root == null )
        {
            return;
        }
        
        travel( root.left );
        if( first == null && root.val <= last.val )
        {
            first = last;
        }
        if( first != null && root.val <= last.val )
        {
            second = root;
        }
        
        last = root;
        travel( root.right);
    }
    
}
