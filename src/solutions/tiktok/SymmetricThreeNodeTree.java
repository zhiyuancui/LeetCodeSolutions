package solutions.tiktok;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

class TripleNode {
    TripleNode left;
    TripleNode right;
    TripleNode mid;

    int val;

    public TripleNode(int val) {
        this.val = val;
    }
}

public class SymmetricThreeNodeTree {

    public boolean isSymmetric(TripleNode root) {
        if(root == null) {
            return true;
        }
        Queue<TripleNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.mid);
        q.add(root.right);

        while (!q.isEmpty()) {
            TripleNode left = q.poll();
            TripleNode mid = q.poll();
            TripleNode right = q.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null ) return false;
            if (left.val != right.val) return false;

            q.add(left.left);
            q.add(mid.mid);
            q.add(right.right);

            q.add(left.mid);
            q.add(mid.mid);
            q.add(right.mid);

            q.add(left.right);
            q.add(mid.mid);
            q.add(right.left);

            q.add(mid.left);
            q.add(mid.mid);
            q.add(mid.right);
        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricThreeNodeTree s = new SymmetricThreeNodeTree();
        TripleNode root = new TripleNode(1);
        root.left = new TripleNode(2);
        root.left.left = new TripleNode(5);
        root.left.mid = new TripleNode(6);
        root.left.right = new TripleNode(7);

        root.mid = new TripleNode(3);
        root.mid.left = new TripleNode(8);
        root.mid.mid = new TripleNode(9);
        root.mid.right = new TripleNode(8);

        root.right = new TripleNode(2);

        root.right.left = new TripleNode(7);
        root.right.mid = new TripleNode(6);
        root.right.right = new TripleNode(5);

        //Not Symmetric
        root.right.right.left = new TripleNode(7);
        root.right.right.mid = new TripleNode(6);
        root.right.right.right = new TripleNode(5);

        Assert.assertTrue(s.isSymmetric(root));
    }
}
