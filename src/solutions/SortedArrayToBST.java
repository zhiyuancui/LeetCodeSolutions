package solutions;

import util.TreeNode;

/**
 * 108 Convert Sorted Array to Binary Search Tree
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return null;
        }
        
        return buildTree(nums, 0, nums.length - 1 );
    }
    
    private TreeNode buildTree(int[] nums, int start, int end){
        if( start > end ){
            return null;
        }
        
        int mid = start + ( end - start ) / 2;
        TreeNode root = new TreeNode( nums[ mid ] );
        root.left = buildTree(nums, start, mid - 1 );
        root.right = buildTree( nums, mid + 1, end );
        
        return root;
    }
}
