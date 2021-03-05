package solutions;

import util.TreeNode;

public class DistributeCoinsInBT {
    int ans;
    public int distributeCoins(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        ans += Math.abs(left) + Math.abs(right);

        return root.val + left + right - 1;
    }
}
