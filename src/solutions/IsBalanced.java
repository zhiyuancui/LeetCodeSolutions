/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, 
 * a height-balanced binary tree is defined 
 * as a binary tree in which 
 * the depth of the two subtrees of every node 
 * never differ by more than 1.
 * 
 */

package solutions;

import util.TreeNode;

/**
 * 110 Balanced Binary Tree
 */
public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
        if( root == null )
        {
            return true;
        }
        
        return getHeight( root ) != -1;
    }
    
    public int getHeight( TreeNode root )
    {
        if( root == null )
        {
            return 0;
        }
        
        int left  = getHeight( root.left );
        int right = getHeight( root.right);
        
        if( left == -1 || right == -1 )
        {
            return -1;
        }
        
        if( Math.abs(left-right) > 1 )
        {
            return -1;
        }
        
        return Math.max(left, right ) + 1;
    }
}
