package solutions.amazon;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 662 Maximum Width of Binary Tree
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Node> queue = new LinkedList();
        queue.add(new Node(root, 1));
        int left = 0, ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i == 0) {
                    left = cur.pos;
                }
                if (cur.node.left != null) {
                    queue.add(new Node(cur.node.left, cur.pos * 2));
                }
                if (cur.node.right != null) {
                    queue.add(new Node(cur.node.right, cur.pos * 2 + 1));
                }
                ans = Math.max(ans, cur.pos - left + 1);
            }
        }
        return ans;
    }

    class Node {
        TreeNode node;
        int pos;

        Node(TreeNode n, int p) {
            node = n;
            pos = p;
        }
    }
}
