package solutions;

import util.ListNode;

/**
 * 24 Swap Nodes in Pairs
 */
public class SwapPairs {
	
public ListNode swapPairs(ListNode head) {
        
        if( head == null || head.next == null )
        {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        
        while( fast != null && fast.next != null )
        {
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = fast;
            
            //move the pointer
            fast = fast.next;
            slow = slow.next.next;
        }
        
        return dummy.next;
    }
}
