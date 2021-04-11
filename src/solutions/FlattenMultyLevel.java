package solutions;

import java.util.Stack;

public class FlattenMultyLevel {
    class Node {
        Node next;
        Node prev;
        Node child;
    }
    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }

        Node dummy = new Node();
        Node prev = dummy;


        boolean hasChild = false;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        int count = 0;
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            prev.next = cur;
            cur.prev = prev;
            if(cur.next != null ) {
                stack.push(cur.next);
            }
            if(cur.child != null) {
                stack.push(cur.child);
                cur.child = null;
            }

            prev = prev.next;
        }

        dummy.next.prev = null;
        return dummy.next;
    }
}
