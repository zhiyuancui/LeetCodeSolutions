package solutions;

import util.*;

public class HasCycle {
	
	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
        
        if( head == null || head.next == null )
        {
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast.next != null && fast.next.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
            if( fast.val == slow.val )
            {
                return true;
            }
        }
        
        return false;
    }
}
