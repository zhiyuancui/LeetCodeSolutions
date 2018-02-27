package solutions;

import util.TreeNode;

public class SplitBST {
	public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode small = new TreeNode(0);
        TreeNode curSm = small;
        TreeNode large = new TreeNode(0);
        TreeNode curLg = large;

        while (root != null) {
            if (root.val <= V) {
                curSm.right = root;
                curSm = root;
                root = root.right;
                curSm.right = null;
            } else {
                curLg.left = root;
                curLg = root;
                root = root.left;
                curLg.left = null;
            }
        }
        return new TreeNode[] {small.right, large.left};
    }
}
