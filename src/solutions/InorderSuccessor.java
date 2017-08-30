package solutions;

import util.TreeNode;

public class InorderSuccessor {

	/**
	 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
	 * 
	 * Note: If the given node has no in-order successor in the tree, return null.
	 * 
	 * Reference to : https://leetcode.com/discuss/77805/java-5ms-short-code-with-explanations
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        
        while( root != null ){
	        	if( root.val > p.val ){
	        		result = root;
	        		root = root.left;
	        	}else{
	        		root = root.right;
	        	}
        }
        
        return result;
    }
	
}
