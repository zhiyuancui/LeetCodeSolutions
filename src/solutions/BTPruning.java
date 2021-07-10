package solutions;

import util.TreeNode;

/**
 * 814 Binary Tree Pruning
 */
public class BTPruning {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        int result = helper(root);

        return result == 0 ? null : root;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if(left == 0) {
            root.left = null;
        }

        if(right == 0) {
            root.right = null;
        }

        if(root.val == 1 || left == 1 || right == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
