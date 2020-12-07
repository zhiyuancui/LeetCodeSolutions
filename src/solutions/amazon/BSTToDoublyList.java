package solutions.amazon;

import util.TreeNode;

import java.util.Stack;

public class BSTToDoublyList {

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null ) {
            return root;
        }

        TreeNode head = null;
        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(head == null) {
                head = root;
            } else {
                prev.right = root;
            }
            root.left = prev;
            prev = root;
            root = root.right;
        }

        prev.right = head;
        head.left = prev;

        return head;
    }
}
