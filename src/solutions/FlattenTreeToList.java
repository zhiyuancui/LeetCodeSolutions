package solutions;

import util.TreeNode;


/**
 * 114 Flatten Binary Tree to Linked List
 */
public class FlattenTreeToList {
	public void flatten(TreeNode root) {
        if( root == null )
        {
            return;
        }
        
        flatten( root.left  );
        flatten( root.right );
        
        TreeNode tail = root.left;
        if( tail == null )
        {
            return;
        }

        while( tail.right != null )
        {
            tail = tail.right;
        }
        
        tail.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
