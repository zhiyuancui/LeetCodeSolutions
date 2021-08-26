package solutions;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 919 Complete Binary Tree Inserter
 */
public class CBTInserter {
    TreeNode root;
    Deque<TreeNode> deque = new LinkedList<>();
    public CBTInserter(TreeNode root) {
        this.root = root;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left == null || node.right == null) {
                deque.offerLast(node);
            }
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));

        if(node.left == null) {
            node.left = deque.peekLast();
        } else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
