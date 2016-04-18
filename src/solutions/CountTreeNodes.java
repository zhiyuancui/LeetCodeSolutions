package solutions;

import util.TreeNode;

public class CountTreeNodes {
	
	public int countNodes(TreeNode root) {
        
        if( root == null ){
            return 0;
        }
        
        int left = getHeight( root.left );
        int right = getHeight( root.right );
        
        if( left == right ){
            return ( 1 << left ) + countNodes( root.right );
        }
        else{
            return ( 1 << right ) + countNodes( root.left );
        }
    }
    
    private int getHeight(TreeNode root){
        if( root == null ){
            return 0;
        }
        
        return 1 + getHeight( root.left );
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
