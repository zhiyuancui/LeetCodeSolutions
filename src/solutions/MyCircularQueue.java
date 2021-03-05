package solutions;

class MyCircularQueue {

    class Node {
        int val;
        Node prev;
        Node next;

        public Node(int value) {
            this.val = value;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = new Node(0);
    Node tail = new Node(0);
    int capacity = 0;
    int count = 0;

    public MyCircularQueue(int k) {
        this.capacity = k;
        head.next = tail;
        tail.prev = head;
    }

    public boolean enQueue(int value) {
        if(count >= capacity) {
            return false;
        } else {
            Node prev = tail.prev;
            Node node = new Node(value);
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
            count++;
            return true;
        }
    }

    public boolean deQueue() {
        if(count <=0) {
            return false;
        } else {
            count--;
            Node next = head.next.next;
            head.next = next;
            next.prev = head;
            return true;
        }
    }

    public int Front() {
        if(count > 0) {
            return head.next.val;
        } else {
            return -1;
        }
    }

    public int Rear() {
        if(count > 0) {
            return tail.prev.val;
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
