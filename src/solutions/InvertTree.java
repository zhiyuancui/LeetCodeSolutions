/**
 * invert a binary tree
 */

package solutions;

import util.*;

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
