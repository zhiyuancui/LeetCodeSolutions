/**
 * invert a binary tree
 */

package solutions;

import util.*;

/**
 * 226 Invert Binary Tree
 */
public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
        
        if( root == null )
        {
            return null;
        }
        
        TreeNode left = root.left;
        root.left = invertTree( root.right );
        root.right = invertTree( left );
        
        return root;
        
    }
}
