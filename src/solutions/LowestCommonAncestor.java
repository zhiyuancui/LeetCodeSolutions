package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import util.TreeNode;

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
	
	
	/**
	 * Iterative Method
	 * Lowest Common Ancestor
	 */
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		parent.put(root, null);
		
		stack.push(root);
		
		while( !parent.containsKey( p ) || !parent.containsKey(q) ){
			TreeNode cur = stack.pop();
			if( cur.left != null ){
				parent.put(cur.left, cur);
				stack.push( cur.left );
			}
			
			if( cur.right != null ){
				parent.put(cur.right, cur);
				stack.push( cur.right );
			}
		}
		
		Set<TreeNode> ancestors = new HashSet<TreeNode>();
		while( p != null ){
			ancestors.add(p);
			p = parent.get(p);
		}
		
		while( !ancestors.contains(q) ){
			q = parent.get(q);
		}
		
		return q;
	}
}
