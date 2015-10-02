package solutions;

import util.TreeNode;

public class BuildTree {
	
	/**
	 * Construct Binary Tree from Preorder and Inorder Traversal
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder.length != inorder.length )
        {
            return null;
        }
        
        return myBuildTree(inorder,0,inorder.length-1, preorder, 0,preorder.length-1);
    }
    
    private TreeNode myBuildTree(int[] inorder, int inStart, int inEnd,
                                 int[] preorder, int preStart, int preEnd )
             {
                 if( inStart > inEnd )
                 {
                     return null;
                 }
                 
                 TreeNode root = new TreeNode( preorder[ preStart] );
                 
                 int pos = getinorderIndex(root.val, inorder, inStart, inEnd );
                 
                 root.left = myBuildTree(inorder, inStart, pos - 1,
                                         preorder, preStart + 1, preStart + pos - inStart);
                 root.right = myBuildTree(inorder, pos + 1, inEnd,
                                         preorder, preStart + pos - inStart+1, preEnd); 
                 
                 return root;
             }
    
    private int getinorderIndex(int val, int[] inorder,int start, int end )
    {
        for( int i = start; i <= end; i++ )
        {
            if( inorder[i] == val )
            {
                return i;
            }
        }
        
        return -1;
    }
}
