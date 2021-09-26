package solutions;

import util.TreeNode;

/**
 * 1448 Count Good Nodes in Binary Tree
 */
public class CountGoodNodesinBT {
    int nodeNum = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return nodeNum;
    }

    public void helper(TreeNode node, int max) {
        if(node == null) {
            return;
        }

        if(node.val >= max) {
            nodeNum++;
            max = node.val;
        }

        helper(node.left, max);
        helper(node.right, max);
    }
}
