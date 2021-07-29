package solutions;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1382 Balance a Binary Search Tree
 */
public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            nodes.add(root.val);
            root = root.right;
        }

        return buildTree(nodes, 0, nodes.size() -1);
    }

    private TreeNode buildTree(List<Integer> nodes, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = buildTree(nodes, start, mid-1);
        root.right = buildTree(nodes, mid + 1, end);

        return root;
    }
}
