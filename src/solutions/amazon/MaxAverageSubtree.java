package solutions.amazon;

import util.TreeNode;

public class MaxAverageSubtree {
    double resaver = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return resaver;
    }

    private Entry helper(TreeNode root){
        if (root==null){
            return new Entry(0,0.0);
        }
        Entry left = helper(root.left);
        Entry right = helper(root.right);
        double sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;
        double aver = sum/count;
        if (aver>resaver){
            resaver = aver;
        }
        return new Entry(count, sum);

    }

    static class Entry{
        int count;
        double sum;
        Entry(int count, double sum){
            this.count = count;
            this.sum = sum;
        }
    }
}
