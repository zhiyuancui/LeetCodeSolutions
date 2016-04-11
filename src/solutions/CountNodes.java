package solutions;

import util.TreeNode;

public class CountNodes {
	
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
}
