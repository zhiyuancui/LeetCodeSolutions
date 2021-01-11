package solutions;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    class Node {
        TreeNode node;
        int code;
        Node(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(root, 1));
        int count = 0;
        int last = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                count++;
                last = cur.code;
                if(cur.node.left != null) {
                    int code = cur.code * 2;
                    queue.add(new Node(cur.node.left, code));
                }
                if(cur.node.right != null) {
                    int code = cur.code * 2 + 1;
                    queue.add(new Node(cur.node.right, code));
                }
            }
        }

        return last == count;
    }
}
