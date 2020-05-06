package solutions;

import util.TreeNode;

public class MinDepth {

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return getDepth(root);
    }

    private int getDepth(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
