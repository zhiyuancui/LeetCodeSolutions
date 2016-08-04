package solutions;

import util.TreeNode;

public class CountTreeNodes {
	
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
    
    public static void main(String[] args){
    	CountTreeNodes c = new CountTreeNodes();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right =new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	root.left.left.left = new TreeNode(8);
    	c.countNodes(root);
    }
}
