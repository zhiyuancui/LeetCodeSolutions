package solutions;

import util.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * 
 * For example,
 * 1
 *  \
 *   3
 *  / \
 *  2   4
 *  	\
 *       5
 *       
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * 
 * Reference to : 
 * 
 * 
 * @author Zhiyuan
 *
 */
public class BSTConsecutiveSequence {
	private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null){
        	return 0;
        }
        helper(root, 0, root.val);
        return max;
    }

    public void helper(TreeNode root, int len, int target){
        if(root == null) {
        		return;
        }
        if(root.val == target) {
        		len++;
        }else{
        		len = 1;
        }
        max = Math.max(len, max);
        helper(root.left, len, root.val + 1);
        helper(root.right, len, root.val + 1);
    }
    
    /**
    	     * Binary Tree Longest Consecutive Sequence II
    	     * @param root
    	     * @return
    	     */
    int maxval = 0;
	    public int longestConsecutive2(TreeNode root) {
	    	longestPath(root);
	        return maxval;
	    }
	    public int[] longestPath(TreeNode root) {
	        if (root == null)
	            return new int[] {0,0};
	        int inr = 1, dcr = 1;
	        if (root.left != null) {
	            int[] l = longestPath(root.left);
	            if (root.val == root.left.val + 1)
	                dcr = l[1] + 1;
	            else if (root.val == root.left.val - 1)
	                inr = l[0] + 1;
	        }
	        if (root.right != null) {
	            int[] r = longestPath(root.right);
	            if (root.val == root.right.val + 1)
	                dcr = Math.max(dcr, r[1] + 1);
	            else if (root.val == root.right.val - 1)
	                inr = Math.max(inr, r[0] + 1);
	        }
	        maxval = Math.max(maxval, dcr + inr - 1);
	        return new int[] {inr, dcr};
	    }
}
