package solutions;

import java.util.Stack;

import util.TreeNode;

public class KthSmallest {

	public int kthSmallest(TreeNode root, int k) {
        
        if( root == null )
        {
            return 0;
        }
        
        int count = 0;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while( !stack.isEmpty() || root != null )
        {
            while( root != null )
            {
                stack.push( root );
                root = root.left;
            }
            
            root = stack.pop();
            count++;
            if( count == k )
            {
                return root.val;
            }
            root = root.right;
        }
        
        return 0;
    }
	
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
