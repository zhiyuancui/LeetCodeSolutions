package solutions;

import util.TreeNode;

/**
 * 1379 Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */
public class FindACorrespondingNode {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode t1, TreeNode t2, TreeNode t3) {
        if(t1 == null) {
            return null;
        }
        if(t1 == t3) {
            return t2;
        }

        TreeNode left = dfs(t1.left, t2.left, t3);
        if(left != null) {
            return left;
        }
        TreeNode right = dfs(t1.right, t2.right, t3);

        return right;
    }
}
