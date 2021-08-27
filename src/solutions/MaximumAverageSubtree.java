package solutions;

import util.TreeNode;

/**
 * 1120 Maximum Average Subtree
 */
public class MaximumAverageSubtree {
    double max = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) {
            return 0.0;
        }

        helper(root);

        return max;
    }


    private double[] helper(TreeNode root) {
        if(root == null) {
            return new double[]{0,0};
        }

        double[] left = helper(root.left);
        double[] right = helper(root.right);

        double sum = root.val + left[0] + right[0];
        double count = left[1] + right[1] + 1;

        max = Math.max(max, sum / count);

        return new double[]{sum, count};
    }
}
