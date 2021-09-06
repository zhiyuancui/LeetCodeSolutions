package solutions;

import util.TreeNode;

/**
 * 998 Maximum Binary Tree II
 */
public class MaximumBTII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if(root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
