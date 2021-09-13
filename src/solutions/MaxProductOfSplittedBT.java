package solutions;

import util.TreeNode;

/**
 * 1339 Maximum Product of Splitted Binary Tree
 * https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/solution/java-di-gui-by-hu-li-hu-wai-p831/
 */
public class MaxProductOfSplittedBT {
    long sum = 0;
    long best = 0;

    public int maxProduct(TreeNode root) {
        if(root == null) {
            return 0;
        }

        getSum(root);
        dfs(root);

        return (int)(( best * (sum - best) ) % 1000000007);
    }

    private void getSum(TreeNode node) {
        if(node == null) {
            return;
        }

        sum += node.val;
        getSum(node.left);
        getSum(node.right);
    }

    private long dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }

        long cur = dfs(node.left) + dfs(node.right) + node.val;

        if(Math.abs(cur*2 - sum) < Math.abs(best*2 - sum)) {
            best = cur;
        }

        return cur;
    }
}
