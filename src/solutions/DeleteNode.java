package solutions;

import util.*;

/**
 * 237 Delete Node in a Linked List
 */
public class DeleteNode {
	
	public void deleteNode(ListNode node) {
	     
        while( node.next.next != null )
        {
            node.val = node.next.val;
            node = node.next;
        }
        
        node.val = node.next.val;
        node.next = null;
    }
}
