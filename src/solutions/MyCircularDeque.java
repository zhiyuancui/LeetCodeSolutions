package solutions;

/**
 * 641 Design Circular Deque
 */
class MyCircularDeque {

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
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        head.next = tail;
        tail.prev = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count >= capacity) {
            return false;
        } else {
            Node next = head.next;
            Node node = new Node(value);
            node.next = next;
            node.prev = head;
            head.next = node;
            next.prev = node;
            count++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
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

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
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

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count <= 0) {
            return false;
        } else {
            count--;
            Node prev = tail.prev.prev;
            prev.next = tail;
            tail.prev = prev;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(count > 0) {
            return head.next.val;
        } else {
            return -1;
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(count > 0) {
            return tail.prev.val;
        } else {
            return -1;
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}

