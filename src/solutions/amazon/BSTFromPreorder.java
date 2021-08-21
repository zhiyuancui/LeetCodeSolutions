package solutions.amazon;

import util.TreeNode;

import java.util.Stack;

/**
 * 1008 Construct Binary Search Tree Preorder Traversal
 */
public class BSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }

        int n = preorder.length;

        if(n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        for(int i = 1; i < n; i++) {
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            while(!stack.isEmpty() && stack.peek().val < child.val) {
                node = stack.pop();
            }

            if(node.val < child.val) {
                node.right = child;
            } else {
                node.left = child;
            }

            stack.push(child);
        }

        return root;
    }
}
