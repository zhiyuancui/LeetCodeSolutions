package solutions;

import java.util.Random;

import util.ListNode;

/**
 * 382 Linked List Random Node
 */
public class LinkedListRandomNode {

	
	ListNode head;
	Random random;
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode(ListNode h) {
	    head = h;
	    random = new Random();
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
	    ListNode c = head;
	    int r = c.val;
	    for(int i = 1; c.next != null; i++){
	        c = c.next;
	        if( random.nextInt(i+1) == i ) r = c.val;
	    }
	    
	    return r;
	}
}
