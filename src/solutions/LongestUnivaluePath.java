package solutions;

import util.TreeNode;

public class LongestUnivaluePath {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) {
            return 0;
        }

        travesal(root);
        return ans;
    }

    private int travesal(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = travesal(root.left);
        int right = travesal(root.right);

        int leftLen = 0, rightLen = 0;
        if(root.left != null && root.left.val == root.val) {
            leftLen += left + 1;
        }
        if(root.right != null && root.right.val == root.val) {
            rightLen += right + 1;
        }

        ans = Math.max(ans, leftLen+rightLen);
        return Math.max(leftLen, rightLen);
    }
}
