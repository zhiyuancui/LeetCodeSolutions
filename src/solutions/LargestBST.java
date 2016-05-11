package solutions;

import util.TreeNode;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
 * where largest means subtree with largest number of nodes in it.
 * 
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 * 
 *  10
 *  / \
 *  5  15
 * / \   \ 
 *1   8   7
 *The Largest BST Subtree in this case is the highlighted one. 
 *The return value is the subtree's size, which is 3.
 * 
 * 
 * @author Zhiyuan
 *
 *
 *Reference to : https://leetcode.com/discuss/86027/share-my-o-n-java-code-with-brief-explanation-and-comments
 */
public class LargestBST {
	
	class Result { 
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
	
	private int max = 0;
	public int largestBSTSubtree(TreeNode root) {
        if( root == null ){
        	return 0;
        }
        
        traverse(root, null);
        return max;
    }
	
	private Result traverse(TreeNode root, TreeNode parent){
		if( root == null ){
			return new Result(0, parent.val, parent.val);
		}
		
		Result left = traverse( root.left, root);
		Result right = traverse( root.right, root);
		
		if( left.size == -1 || right.size == -1 || root.val < left.upper || root.val > right.lower ){
			return new Result(-1,0,0);
		}
		
		int size = left.size + 1 + right.size;
		max = Math.max(size, max);
		return new Result(size, left.lower, right.upper);
	}
}
