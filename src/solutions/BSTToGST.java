package solutions;

import util.TreeNode;

import java.util.Stack;

public class BSTToGST {
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) {
            return root;
        }

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }

        return root;
    }
}
