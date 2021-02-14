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
                                 int[] preorder, int preStart, int preEnd ) {
         if( inStart > inEnd )
         {
             return null;
         }
         
         TreeNode root = new TreeNode( preorder[ preStart ] );
         
         int pos = getinorderIndex(root.val, inorder, inStart, inEnd );
         
         root.left = myBuildTree(inorder, inStart, pos - 1,
                                 preorder, preStart + 1, preStart + pos - inStart);
         root.right = myBuildTree(inorder, pos + 1, inEnd,
                                 preorder, preStart + pos - inStart+1, preEnd); 
         
         return root;
     }
    
    private int getinorderIndex(int val, int[] inorder,int start, int end ) {
        for( int i = start; i <= end; i++ )
        {
            if( inorder[i] == val )
            {
                return i;
            }
        }
        
        return -1;
    }
    
    
    /**
     *  Construct Binary Tree from Inorder and Postorder Traversal
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if( inorder == null || postorder == null || inorder.length != postorder.length ){
            return null;
        }
        
        return myBuildTree2(inorder, 0, inorder.length - 1, postorder,0, postorder.length - 1);
    }
    
    private TreeNode myBuildTree2(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if( inStart > inEnd ){
            return null;
        }
        TreeNode root = new TreeNode( postorder[postEnd] );
        
        int pos = getInorderIndex2(root.val, inorder, inStart, inEnd);
     
        root.left = myBuildTree2(inorder, inStart, pos - 1, postorder,postStart, postStart + (pos - inStart) - 1);
        root.right = myBuildTree2(inorder, pos+1, inEnd, postorder,postStart + (pos - inStart), postEnd-1);
        return root;
    }
    
    private int getInorderIndex2(int val, int[] inorder,int start, int end){
        for(int i = start; i <= end; i++){
            if( inorder[i] == val ){
                return i;
            }
        }
        
        return -1;
    }

    /**
     * Construct Binary Tree from Preorder and Postorder Traversal
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if( pre.length != post.length )
        {
            return null;
        }

        return buildTree(0,0, pre.length, pre, post);
    }

    private TreeNode buildTree(int start, int end, int size, int[] pre, int[] post) {
        System.out.println("start: " + start+" end: " + end +" size:" + size);
        if(size <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[start]);

        if(size == 1) {
            return root;
        }

        int left = 1;
        for(; left < size; left++) {
            if(post[end+left-1] == pre[start+1]) {
                break;
            }
        }

        root.left = buildTree(start+1, end, left, pre, post);
        root.right = buildTree(start+left+1, end+left, size-1-left, pre, post);
        return root;
    }
    }

}
