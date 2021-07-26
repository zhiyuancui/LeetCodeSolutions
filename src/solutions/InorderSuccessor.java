package solutions;

import util.TreeNode;

/**
 * 285 Inorder Successor in BST
 */
public class InorderSuccessor {
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
