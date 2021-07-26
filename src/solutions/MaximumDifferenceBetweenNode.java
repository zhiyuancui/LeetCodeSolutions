package solutions;

import util.TreeNode;

/**
 * 1026 Maximum Difference Between Node and Ancestor
 */
public class MaximumDifferenceBetweenNode {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return getAncestor(root, root.val, root.val);
    }

    private int getAncestor(TreeNode root, int max, int min) {
        if(root == null) {
            return max - min;
        }

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        int left = getAncestor(root.left, max, min);
        int right = getAncestor(root.right, max, min);

        return Math.max(left, right);
    }
}
