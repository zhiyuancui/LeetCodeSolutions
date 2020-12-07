package solutions.amazon;

public class InsertCircularList {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node cur = head.next;

        boolean toInsert = false;

        do {
            if(prev.val <= insertVal && insertVal <= cur.val) {
                toInsert = true;
            } else if(prev.val > cur.val) {
                if(insertVal >= prev.val || insertVal <= cur.val) {
                    toInsert = true;
                }
            }

            if(toInsert) {
                prev.next = new Node(insertVal, cur);
                return head;
            }

            prev = cur;
            cur = cur.next;
        } while(prev!=head);

        prev.next = new Node(insertVal, cur);
        return head;
    }
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
