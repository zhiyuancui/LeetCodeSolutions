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

    public void helper(TreeNode root, int cur, int target){
        if(root == null) {
        	return;
        }
        if(root.val == target) {
        	cur++;
        }
        else{
        	cur = 1;
        }
        max = Math.max(cur, max);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}
