package solutions;

import util.TreeNode;

/**
 * 222 Count Complete Tree Nodes
 */
public class CountCompleteTreeNode {
	
	public int countNodes(TreeNode root) {
        
        if( root == null ){
            return 0;
        }
        
        int left = getLeftHeight( root );
        int right = getRightHeight( root );
        
        if( left == right ){
            return ( 1 << left ) - 1;
        }
        else{
            return 1 + countNodes( root.left ) + countNodes( root.right );
        }
    }
    
    private int getLeftHeight(TreeNode root){
        int height = 0;
        while( root != null ){
        	root = root.left;
        	height++;
        }
        return height;
    }
    
    private int getRightHeight(TreeNode root){
        int height = 0;
        while( root != null ){
        	root = root.right;
        	height++;
        }
        return height;
    }
}
