package solutions;

import util.TreeLinkNode;

/**
 * 116 Populating Next Right Pointers in Each Node
 * 117 Populating Next Right Pointers in Each Node II
 */
public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if( root == null )
        {
            return root;
        }

        Node cur = root;
        while( cur != null )
        {
            Node prev = null;
            Node next = null;
            for(; cur != null; cur = cur.next )
            {
                if( next == null )
                {
                    next = cur.left == null ? cur.right : cur.left;
                }

                if( cur.left != null )
                {
                    if( prev != null )
                    {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }

                if( cur.right != null )
                {
                    if( prev != null )
                    {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
            }

            cur = next;
        }

        return root;
    }
}
