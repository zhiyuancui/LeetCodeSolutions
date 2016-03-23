package solutions;

import util.*;

public class LowestCommonAncestor {
	
	/**
	 * In a binary Search Tree
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null )
        {
            return root;
        }
        
        if( p.val > q.val )
        {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        
        if( p.val <= root.val && root.val <= q.val )
        {
            return root;
        }
        else if( p.val < root.val && q.val < root.val )
        {
            return lowestCommonAncestor( root.left, p , q);
        }
        
       else
        {
            return lowestCommonAncestor( root.right, p , q);
        }
    }
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null){
            return root;    
        } 
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        
        
        return left != null ? left : right;
    }
	
}
