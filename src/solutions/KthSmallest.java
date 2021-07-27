package solutions;

import java.util.Stack;

import util.TreeNode;

/**
 * 230 Kth Smallest Element in a BST
 */
public class KthSmallest {
	
	/**
	 * Binary Search Method
	 * 
	 * Reference to https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive
	 * 
	 */
	public int kthSmallest2(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest2(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest2(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode node) {
        if (node == null) {
        	return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
